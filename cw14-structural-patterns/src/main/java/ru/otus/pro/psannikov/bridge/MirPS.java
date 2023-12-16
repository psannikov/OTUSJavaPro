package ru.otus.pro.psannikov.bridge;

public class MirPS implements PaymentSystem {
    @Override
    public void printName() {
        System.out.println("Mir");
    }
}
