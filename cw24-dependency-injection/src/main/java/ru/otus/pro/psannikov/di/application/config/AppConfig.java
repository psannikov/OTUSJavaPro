package ru.otus.pro.psannikov.di.application.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.otus.pro.psannikov.di.application.services.EquationPreparer;
import ru.otus.pro.psannikov.di.application.services.GameProcessor;
import ru.otus.pro.psannikov.di.application.services.impl.EquationPreparerImpl;
import ru.otus.pro.psannikov.di.application.services.impl.GameProcessorImpl;
import ru.otus.pro.psannikov.di.application.services.IOService;
import ru.otus.pro.psannikov.di.application.services.impl.IOServiceStreams;
import ru.otus.pro.psannikov.di.application.services.PlayerService;

@Configuration
public class AppConfig {

    @Bean
    public GameProcessor gameProcessor(IOService ioService,
                                       PlayerService playerService,
                                       EquationPreparer equationPreparer) {
        return new GameProcessorImpl(ioService, equationPreparer, playerService);
    }

    @Bean
    public IOService ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}
