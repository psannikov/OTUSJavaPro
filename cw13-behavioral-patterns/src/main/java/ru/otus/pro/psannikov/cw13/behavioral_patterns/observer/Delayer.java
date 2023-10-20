package ru.otus.pro.psannikov.cw13.behavioral_patterns.observer;

public class Delayer {
    public static void delay() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
