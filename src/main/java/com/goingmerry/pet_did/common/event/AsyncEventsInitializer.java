package com.goingmerry.pet_did.common.event;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;

@Component
public class AsyncEventsInitializer {

    @PostConstruct
    public void init() {
        AsyncEvents.init(Executors.newFixedThreadPool(10));
    }

    @PreDestroy
    public void close() {
        AsyncEvents.close();
    }
}
