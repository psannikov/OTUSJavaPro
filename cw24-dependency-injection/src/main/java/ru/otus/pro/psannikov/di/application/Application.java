package ru.otus.pro.psannikov.di.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ru.otus.pro.psannikov.di.application.services.EquationPreparer;
import ru.otus.pro.psannikov.di.application.services.GameProcessor;
import ru.otus.pro.psannikov.di.application.services.IOService;
import ru.otus.pro.psannikov.di.application.services.PlayerService;
import ru.otus.pro.psannikov.di.application.services.impl.EquationPreparerImpl;
import ru.otus.pro.psannikov.di.application.services.impl.GameProcessorImpl;
import ru.otus.pro.psannikov.di.application.services.impl.IOServiceStreams;
import ru.otus.pro.psannikov.di.application.services.impl.PlayerServiceImpl;

@ComponentScan
public class Application {
    public static void main(String[] args) {
//        EquationPreparer equationPreparer = new EquationPreparerImpl();
//        IOService ioService = new IOServiceStreams(System.out, System.in);
//        PlayerService playerService = new PlayerServiceImpl(ioService);
//        GameProcessor gameProcessor = new GameProcessorImpl(ioService, equationPreparer, playerService);

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        GameProcessor gameProcessor = context.getBean(GameProcessor.class);

        gameProcessor.startGame();
    }
}
