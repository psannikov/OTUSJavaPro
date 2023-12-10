package ru.otus.pro.psannikov.cw13.behavioral_patterns.strategy;

import ru.otus.pro.psannikov.cw13.behavioral_patterns.command.data.Guest;


public class GuestExample {
    public static void main(String[] args) {
        Guest guest = new Guest("Ivan Ivanov");

        Charger.charge(guest, Charger.Charges.ROOM);
        Charger.charge(guest, Charger.Charges.EXTRABED);


        System.out.println(guest);
    }
}
