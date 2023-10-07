package ru.otus.pro.psannikov.cw12.creational_patterns;

public class Singleton {
    public static void main(String[] args) {
        CarForSingleton car = CarForSingleton.getInstance();
    }
}
final class CarForSingleton {
    private static final CarForSingleton INSTANCE = new CarForSingleton();
    public static CarForSingleton getInstance() {
        return INSTANCE;
    }
}
