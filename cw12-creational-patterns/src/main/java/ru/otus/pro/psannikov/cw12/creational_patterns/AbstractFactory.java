package ru.otus.pro.psannikov.cw12.creational_patterns;

public class AbstractFactory {
    public interface Sedan {}
    public interface Coupe {}
    public interface CarsFactory {
        Sedan createSedan();
        Coupe createCoupe();
    }
    public static class ToyotaSedan implements Sedan {}
    public static class ToyotaCoupe implements Coupe {}
    public class FordSedan implements Sedan {}
    public class FordCoupe implements Coupe {}
    public static class ToyotaFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {return new ToyotaSedan();}
        @Override
        public Coupe createCoupe() {return new ToyotaCoupe();}
        }
    public class FordFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {return new FordSedan();}
        @Override
        public Coupe createCoupe() {return new FordCoupe();}
    }
    public static void main(String[] args) {
        AbstractFactory.CarsFactory carsFactory = new AbstractFactory.ToyotaFactory();
        Sedan sedan = carsFactory.createSedan();
        Coupe coupe = carsFactory.createCoupe();
    }
}
