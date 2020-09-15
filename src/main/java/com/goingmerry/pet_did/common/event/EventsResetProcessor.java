package com.goingmerry.pet_did.common.event;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class EventsResetProcessor {

    private ThreadLocal<Integer> nestedCount = ThreadLocal.withInitial(() -> Integer.valueOf(0));

    @Around("@target(org.springframework.stereotype.Service) && within(com.goingmerry.pet_did..*)")
    public Object doReset(ProceedingJoinPoint joinPoint) throws Throwable {
        nestedCount.set(nestedCount.get() + 1);
        try {
            return joinPoint.proceed();
        } finally {
            nestedCount.set(nestedCount.get() - 1);
            if (0 == nestedCount.get()) {
                Events.reset();
            }
        }
    }
}
