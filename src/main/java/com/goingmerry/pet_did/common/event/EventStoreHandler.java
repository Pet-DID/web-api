package com.goingmerry.pet_did.common.event;

import com.goingmerry.pet_did.eventstore.domain.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventStoreHandler implements EventHandler<Object> {

    private final EventStore eventStore;

    @Override
    public void handle(Object event) {
        eventStore.save(event);
    }
}
