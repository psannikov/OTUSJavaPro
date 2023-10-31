package ru.otus.pro.psannikov.hw07.patterns.processor;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public interface Processor {

    Message process(Message message);

}
