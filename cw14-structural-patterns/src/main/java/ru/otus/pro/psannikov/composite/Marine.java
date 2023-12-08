package ru.otus.pro.psannikov.composite;

/**
 * Морской пехотинец.
 */
public class Marine implements Unit {
    @Override
    public void move() {
        System.out.println("Marine is moving");
    }
}
