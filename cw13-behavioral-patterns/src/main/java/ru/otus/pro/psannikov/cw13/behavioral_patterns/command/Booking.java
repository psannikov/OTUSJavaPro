package ru.otus.pro.psannikov.cw13.behavioral_patterns.command;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private final List<Option> options = new ArrayList<>();

    private final Guest guest;

    public Booking(final Guest guest) {
        this.guest = guest;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public Guest checkOut() {
        options.forEach(option -> option.charge(guest));
        return guest;
    }
}
