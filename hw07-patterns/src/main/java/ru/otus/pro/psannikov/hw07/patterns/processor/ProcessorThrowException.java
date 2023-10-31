package ru.otus.pro.psannikov.hw07.patterns.processor;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.time.LocalDateTime;

public class ProcessorThrowException implements Processor {
    @Override
    public Message process(Message message) {
        if (LocalDateTime.now().getSecond() % 2 == 0) {
            throw new RuntimeException("Test Exception");
        }
        return null;
    }
}
