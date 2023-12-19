package ru.otus.pro.psannikov.hw07.patterns;

import ru.otus.pro.psannikov.hw07.patterns.handler.ComplexProcessor;
import ru.otus.pro.psannikov.hw07.patterns.listener.homework.HistoryListener;
import ru.otus.pro.psannikov.hw07.patterns.model.Message;
import ru.otus.pro.psannikov.hw07.patterns.processor.LoggerProcessor;
import ru.otus.pro.psannikov.hw07.patterns.processor.ProcessorChangeField11and12;
import ru.otus.pro.psannikov.hw07.patterns.processor.ProcessorThrowException;

import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        var processors = List.of(new ProcessorChangeField11and12(),
                new LoggerProcessor(new ProcessorThrowException()));

        var complexProcessor = new ComplexProcessor(processors, ex -> {
        });
        var listenerPrinter = new HistoryListener();
        complexProcessor.addListener(listenerPrinter);

        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field6("field6")
                .field10("field10")
                .field11("field11")
                .field12("field12")
                .build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
    }
}
