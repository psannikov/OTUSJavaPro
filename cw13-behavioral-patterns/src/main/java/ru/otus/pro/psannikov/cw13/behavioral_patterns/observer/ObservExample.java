package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

public class ObservExample {
    public static void main(String[] args) {
        EventListener listener1 = new UpdateListener();
        EventListener listener2 = new DeleteListener();

        EventManager manager = new EventManager();
        manager.addListener(listener1);
        manager.addListener(listener2);

        manager.fireEvent(new Event("delete event", EventType.DELETE));
        manager.fireEvent(new Event("update event", EventType.UPDATE));
        manager.fireEvent(new Event("event 3 ",EventType.LIST));

        manager.addListener(new ListListener());
        manager.fireEvent(new Event("event 4 ",EventType.LIST));
        System.out.println("=".repeat(30));
    }
}
