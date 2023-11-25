package ru.otus.pro.psannikov.cw13.behavioral_patterns.command;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;

public class Room implements Option {

    @Override
    public void charge(Guest guest) {
        guest.setRentCost(100);
    }
}
