package ru.otus.pro.psannikov.cw13.behavioral_patterns.strategy;


import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.*;
import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;


public class Charger {
    public enum Charges {
        BREAKFAST(new Breakfast()),
        EXTRABED(new ExtraBed()),
        MINIBAR(new MiniBar()),
        ROOM(new Room());

        Charges(final Option option) {
            this.option = option;
        }

        final Option option;
    }

    public static void charge(Guest user, Charges type) {
        type.option.charge(user);
    }

}
