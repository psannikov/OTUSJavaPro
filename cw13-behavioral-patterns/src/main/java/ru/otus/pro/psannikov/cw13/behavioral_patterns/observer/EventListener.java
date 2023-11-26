package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

public interface EventListener {
    void onEvent (Event event);
    EventType accepts();
}
