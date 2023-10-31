package ru.otus.pro.psannikov.hw07.patterns.listener.homework;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Message> text = new ArrayList<>();

    public void add(Message item) {
        text.add(item.copyOf());
    }

    public void print() {
        text.forEach(item -> System.out.print(item.toString() + " "));
        System.out.println();
    }

    public MementoMessage saveState() {
        return new MementoMessage(text);
    }

    public void restoreState(MementoMessage memento) {
        this.text = memento.getState();
    }
}
