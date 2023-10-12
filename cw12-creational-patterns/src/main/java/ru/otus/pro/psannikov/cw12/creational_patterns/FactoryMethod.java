package ru.otus.pro.psannikov.cw12.creational_patterns;

abstract class CarVehicle {
    public Car create () {return createCar();}
    protected abstract Car createCar();
}
interface Car {}
class SedanCar implements Car{}
class CoupeCar implements Car{}
class SedanCarVehicle extends CarVehicle {
    @Override
    public Car createCar() {return new SedanCar();}
}
class CoupeCarVehicle extends CarVehicle {
    @Override
    public Car createCar() {return new CoupeCar();}
}

public class FactoryMethod {
    public static void main(String[] args) {
        CarVehicle carVehicle1 = new SedanCarVehicle();
        carVehicle1.create();
        CarVehicle carVehicle2 = new CoupeCarVehicle();
        carVehicle2.create();
    }

}
