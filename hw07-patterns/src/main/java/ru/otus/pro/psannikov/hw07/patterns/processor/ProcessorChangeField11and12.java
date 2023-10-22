package ru.otus.pro.psannikov.hw07.patterns.processor;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public class ProcessorChangeField11and12 implements Processor{
    @Override
    public Message process(Message message) {
        String tmpField11 = message.getField11();
        String tmpField12 = message.getField12();
        return message.toBuilder().field11(tmpField12).field12(tmpField11).build();
    }
}
