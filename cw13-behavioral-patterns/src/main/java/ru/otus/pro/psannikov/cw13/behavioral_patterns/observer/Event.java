package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

public class Event {
    private final String data;
    private final EventType eventType;

    public Event(String data, EventType eventType) {
        this.data = data;
        this.eventType = eventType;
    }

    public String getData() {
        return data;
    }

    public EventType getEventType() {
        return eventType;
    }
}
