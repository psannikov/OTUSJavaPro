package ru.otus.pro.psannikov.hw07.patterns.listener;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public interface Listener {

    void onUpdated(Message msg);

}
