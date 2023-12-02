package ru.otus.pro.psannikov.hw07.patterns.listener.homework;

import ru.otus.pro.psannikov.hw07.patterns.listener.Listener;
import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {
    Editor editor = new Editor();
    Caretaker caretaker = new Caretaker();

    @Override
    public void onUpdated(Message msg) {
        editor.add(msg);
        caretaker.setMemento(editor.saveState());
        String message = String.format("Saved message: ", msg);
        System.out.println(message);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(caretaker.getMementoById(id));
    }
}
