package ru.otus.pro.psannikov.hw07.patterns.listener.homework;

import ru.otus.pro.psannikov.hw07.patterns.listener.homework.MementoMessage;
import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {

    private Deque<MementoMessage> stack = new ArrayDeque<>();

    public void setMemento(MementoMessage memento) {
        stack.push(memento);
    }

    public MementoMessage getMemento() {
        return stack.pop();
    }
    public Message getMementoById(long id) {
        for (MementoMessage mementoMessage: stack) {
            for (Message message : mementoMessage.getState()) {
                if (message.getId() == id) {
                    return message;
                }
            }
        }
        throw new UnsupportedOperationException();
    }
}
