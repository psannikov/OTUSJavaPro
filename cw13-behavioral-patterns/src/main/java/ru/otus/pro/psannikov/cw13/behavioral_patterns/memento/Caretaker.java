package ru.otus.pro.psannikov.cw13.behavioral_patterns.memento;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.memento.data.Memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {

    private Deque<Memento> stack = new ArrayDeque<>();

    public void setMemento(Memento memento) {
        stack.push(memento);
    }

    public Memento getMemento() {
        return stack.pop();
    }
}
