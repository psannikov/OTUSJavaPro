package ru.otus.pro.psannikov.cw13.behavioral_patterns.command;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Charge;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;

public class Breakfast implements Option {
    @Override
    public void charge(Guest guest) {
        guest.addCharge(new Charge("breakfast", 20));
    }
}
