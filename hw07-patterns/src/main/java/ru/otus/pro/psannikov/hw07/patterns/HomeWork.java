package ru.otus.pro.psannikov.hw07.patterns;

import ru.otus.pro.psannikov.hw07.patterns.handler.ComplexProcessor;
import ru.otus.pro.psannikov.hw07.patterns.listener.homework.HistoryListener;
import ru.otus.pro.psannikov.hw07.patterns.model.Message;
import ru.otus.pro.psannikov.hw07.patterns.processor.*;

import java.util.List;

public class HomeWork {

    /*
     Реализовать to do:
       2. Сделать процессор, который поменяет местами значения field11 и field12
       3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
             Секунда должна определяьться во время выполнения.
             Тест - важная часть задания
             Обязательно посмотрите пример к паттерну Мементо!
       4. Сделать Listener для ведения истории (подумайте, как сделать, чтобы сообщения не портились)
          Уже есть заготовка - класс HistoryListener, надо сделать его реализацию
          Для него уже есть тест, убедитесь, что тест проходит
     */

    public static void main(String[] args) {
        var processors = List.of(new ProcessorChangeField11and12(),
                new LoggerProcessor(new ProcessorThrowException()));

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
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
