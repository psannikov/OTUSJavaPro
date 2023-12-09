package ru.otus.pro.psannikov.di;

import ru.otus.pro.psannikov.di.appcontainer.AppComponentsContainerImpl;
import ru.otus.pro.psannikov.di.appcontainer.api.AppComponentsContainer;
import ru.otus.pro.psannikov.di.config.AppConfig;
import ru.otus.pro.psannikov.di.services.GameProcessor;

public class App {

    public static void main(String[] args) throws Exception {
            AppComponentsContainer container = new AppComponentsContainerImpl(AppConfig.class);

            GameProcessor gameProcessor = container.getAppComponent(GameProcessor.class);

            gameProcessor.startGame();
    }
}
