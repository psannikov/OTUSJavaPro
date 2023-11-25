package ru.otus.pro.psannikov.cw12.creational_patterns;

public class Prototype {
    public static void main(String[] args) {
        SedanCarForPrototype car1 = new SedanCarForPrototype();
        SedanCarForPrototype car2 = (SedanCarForPrototype) car1.copy();
    }
}
interface CarForPrototype {}
class SedanCarForPrototype implements CarForPrototype {
    public CarForPrototype copy() {
        SedanCarForPrototype car = new SedanCarForPrototype();
        return car;
    }
}
