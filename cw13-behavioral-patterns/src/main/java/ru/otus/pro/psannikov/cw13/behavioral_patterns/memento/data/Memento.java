package ru.otus.pro.psannikov.cw13.behavioral_patterns.memento.data;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private final List<TextItem> state;

    public Memento(final List<TextItem> state) {
        this.state = new ArrayList<>(state);
    }

    public List<TextItem> getState() {
        return state;
    }
}
