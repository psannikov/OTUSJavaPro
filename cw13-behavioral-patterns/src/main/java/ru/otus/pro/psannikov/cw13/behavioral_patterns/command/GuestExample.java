package ru.otus.pro.psannikov.cw13.behavioral_patterns.command;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;

public class GuestExample {
    public static void main(String[] args) {
        Guest guest = new Guest("Ivan Ivanov");

        Booking booking = new Booking(guest);

        booking.addOption(new ExtraBed());
        booking.addOption(new Room());
        booking.addOption(new MiniBar());

        guest = booking.checkOut();

        System.out.println(guest);
    }
}
