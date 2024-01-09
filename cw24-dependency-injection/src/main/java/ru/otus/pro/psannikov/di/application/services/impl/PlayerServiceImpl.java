package ru.otus.pro.psannikov.di.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.pro.psannikov.di.application.model.Player;
import ru.otus.pro.psannikov.di.application.services.IOService;
import ru.otus.pro.psannikov.di.application.services.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

    private IOService ioService;

    public PlayerServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public Player getPlayer() {
        ioService.out("Представьтесь пожалуйста");
        String playerName = ioService.readLn("Введите имя: ");
        return new Player(playerName);
    }
}
