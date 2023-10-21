package ru.otus.pro.psannikov.hw07.patterns.handler;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;
import ru.otus.pro.psannikov.hw07.patterns.listener.Listener;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
