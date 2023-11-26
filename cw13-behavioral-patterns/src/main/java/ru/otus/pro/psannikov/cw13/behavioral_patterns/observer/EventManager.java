package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventManager {
    private Map<EventType, Set<EventListener>> listeners = new HashMap<>();
    public void fireEvent (Event event) {
        listeners.computeIfAbsent(event.getEventType(), key -> new HashSet<>())
                .forEach(listener -> {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onEvent(event);
                        }
                    }).start();
                });
    }
    public void addListener (EventListener listener) {
        listeners.computeIfAbsent(listener.accepts(), key -> new HashSet<>()).add(listener);
    }
}
