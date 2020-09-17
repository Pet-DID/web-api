package com.goingmerry.pet_did.common.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class AsyncEvents {

    private static ThreadLocal<List<EventHandler<?>>> asyncHandlers = new ThreadLocal<>();
    private static ThreadLocal<Boolean> publishing = ThreadLocal.withInitial(() -> Boolean.FALSE);
    private static ExecutorService executor;

    public static void init(ExecutorService executor) {
        AsyncEvents.executor = executor;
    }

    public static void close() {
        if (executor != null) {
            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void raise(Object event) {
        if (publishing.get()) return;

        try {
            publishing.set(Boolean.TRUE);

            List<EventHandler<?>> asyncEventHandlers = asyncHandlers.get();
            if (asyncEventHandlers != null) {
                for (EventHandler handler : asyncEventHandlers) {
                    if (handler.canHandle(event)) {
                        executor.submit(() -> handler.handle(event));
                    }
                }
            }
        } finally {
            publishing.set(Boolean.FALSE);
        }
    }

    public static void handle(EventHandler<?> handler) {
        if (publishing.get()) return;

        List<EventHandler<?>> eventHandlers = asyncHandlers.get();
        if (eventHandlers == null) {
            eventHandlers = new ArrayList<>();
            asyncHandlers.set(eventHandlers);
        }

        eventHandlers.add(handler);
    }

    public static void reset() {
        if (!publishing.get()) {
            asyncHandlers.remove();
        }
    }
}
