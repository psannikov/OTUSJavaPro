package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

public class ListListener implements EventListener{
    @Override
    public void onEvent(Event event) {
        Delayer.delay();
        System.out.println("List " + event.getData());
    }

    @Override
    public EventType accepts() {
        return EventType.LIST;
    }
}
