package com.goingmerry.pet_did.eventstore.domain;

import com.goingmerry.pet_did.eventstore.domain.EventEntry;

import java.util.List;

public interface EventStore {

    void save(Object event);
    List<EventEntry> get(long offset, long limit);
}
