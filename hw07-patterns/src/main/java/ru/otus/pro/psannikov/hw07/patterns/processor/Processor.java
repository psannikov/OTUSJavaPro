package ru.otus.pro.psannikov.hw07.patterns.processor;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

public interface Processor {

    Message process(Message message);

    //todo: 3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
    //         Секунда должна определяьться во время выполнения.
    //         Тест - важная часть задания
    // Обязательно посмотрите пример к паттерну Мементо!
}
