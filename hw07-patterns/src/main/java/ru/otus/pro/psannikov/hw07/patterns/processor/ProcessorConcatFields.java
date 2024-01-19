package ru.otus.pro.psannikov.hw07.patterns.processor;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public class ProcessorConcatFields implements Processor {

    @Override
    public Message process(Message message) {
        var newFieldValue = String.join(" ", "concat:", message.getField1(), message.getField2(), message.getField3());
        return message.toBuilder().field4(newFieldValue).build();
    }
}
