package ru.otus.pro.psannikov.di;

import ru.otus.pro.psannikov.di.appcontainer.AppComponentsContainerImpl;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainer;
import ru.otus.pro.psannikov.di.config.AppConfig;
import ru.otus.pro.psannikov.di.services.GameProcessor;

/*
В классе AppComponentsContainerImpl реализовать обработку, полученной в конструкторе конфигурации,
основываясь на разметке аннотациями из пакета appcontainer. Так же необходимо реализовать методы getAppComponent.
В итоге должно получиться работающее приложение. Менять можно только класс AppComponentsContainerImpl.
Можно добавлять свои исключения.

Раскоментируйте тест:
@Disabled //надо удалить
Тест и демо должны проходить для всех реализованных вариантов
Не называйте свой проект ДЗ "homework-template", это имя заготовки)

PS Приложение представляет собой тренажер таблицы умножения
*/

public class App {

    public static void main(String[] args) throws Exception {
        try {
            // Опциональные варианты
            //AppComponentsContainer container = new AppComponentsContainerImpl(AppConfig1.class, AppConfig2.class);

            // Тут можно использовать библиотеку Reflections (см. зависимости)
            //AppComponentsContainer container = new AppComponentsContainerImpl("ru.otus.config");

            // Обязательный вариант
            AppComponentsContainer container = new AppComponentsContainerImpl(AppConfig.class);

            // Приложение должно работать в каждом из указанных ниже вариантов
            GameProcessor gameProcessor = container.getAppComponent(GameProcessor.class);
            //GameProcessor gameProcessor = container.getAppComponent(GameProcessorImpl.class);
            //GameProcessor gameProcessor = container.getAppComponent("gameProcessor");

            gameProcessor.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
