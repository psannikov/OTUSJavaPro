package ru.otus.pro.psannikov.cw13.behavioral_patterns.memento;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.memento.data.Memento;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.memento.data.TextItem;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<TextItem> text = new ArrayList<>();

    public void add(TextItem item) {
        text.add(item);
    }

    public void print() {
        text.forEach(item -> System.out.print(item.getText() + " "));
        System.out.println();
    }

    public Memento saveState() {
        return new Memento(text);
    }

    public void restoreState(Memento memento) {
        this.text = memento.getState();
    }
}
