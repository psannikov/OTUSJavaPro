package ru.otus.pro.psannikov.hw07.patterns.listener.homework;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MementoMessage {

    private final List<Message> state;

    public MementoMessage(final List<Message> state) {
        this.state = new ArrayList<>(state);
    }

    public List<Message> getState() {
        return state;
    }
}
