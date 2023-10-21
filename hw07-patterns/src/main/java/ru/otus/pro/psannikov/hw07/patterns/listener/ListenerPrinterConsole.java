package ru.otus.pro.psannikov.hw07.patterns.listener;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:%s", msg);
        System.out.println(logString);
    }
}
