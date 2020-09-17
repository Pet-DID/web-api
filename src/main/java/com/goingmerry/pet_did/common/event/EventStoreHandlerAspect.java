package com.goingmerry.pet_did.common.event;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Order(1)
@Component
public class EventStoreHandlerAspect {

    private final EventStoreHandler eventStoreHandler;

    @Before("execution(public * com.goingmerry.pet_did..*Service.*(..))")
    public void registerEventStoreHandler() {
        Events.handle(eventStoreHandler);
    }
}
