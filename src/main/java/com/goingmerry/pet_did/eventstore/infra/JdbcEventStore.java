package com.goingmerry.pet_did.eventstore.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goingmerry.pet_did.eventstore.PayloadConvertException;
import com.goingmerry.pet_did.eventstore.domain.EventEntry;
import com.goingmerry.pet_did.eventstore.domain.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JdbcEventStore implements EventStore {

    private final String DEFAULT_CONTENT_TYPE = "application/json";

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void save(Object event) {
        EventEntry entry = new EventEntry(event.getClass().getName(), DEFAULT_CONTENT_TYPE, toJson(event));

        jdbcTemplate.update(
                "INSERT INTO event_entry (type, content_type, payload, timestamp) VALUES (?, ?, ?, ?)",
                ps -> {
                    ps.setString(1, entry.getType());
                    ps.setString(2, entry.getContentType());
                    ps.setString(3, entry.getPayload());
                    ps.setTimestamp(4, new Timestamp(entry.getTimestamp()));
                }
        );
    }

    private String toJson(Object event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new PayloadConvertException(e);
        }
    }

    @Override
    public List<EventEntry> get(long offset, long limit) {
        return jdbcTemplate.query(
                "SELECT * FROM event_entry ORDER BY id ASC LIMIT ?, ?",
                ps -> {
                    ps.setLong(1, offset);
                    ps.setLong(2, limit);
                },
                (rs, rowNum) ->
                        new EventEntry(
                            rs.getLong("id"),
                            rs.getString("type"),
                            rs.getString("content_type"),
                            rs.getString("payload"),
                            rs.getLong("timestamp")
                        )
        );
    }
}
