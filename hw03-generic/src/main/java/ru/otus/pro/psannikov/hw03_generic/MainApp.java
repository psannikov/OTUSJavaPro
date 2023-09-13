package ru.otus.pro.psannikov.hw03_generic;

public class MainApp {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Box<Fruit> boxFruit1 = new Box<>(apple1,apple2);
        System.out.println("=".repeat(30));
        System.out.println("Contents of boxFruit1: " + boxFruit1.getFruits());
        System.out.println("Weight of boxFruit1 = " + boxFruit1.weight());
        Box<Fruit> boxFruit2 = new Box<>();
        System.out.println("Contents of boxFruit2: " + boxFruit2.getFruits());
        System.out.println("Weight of boxFruit2 = " + boxFruit2.weight());
        System.out.println("Comparison of boxFruit1 and boxFruit2 boxes = " + boxFruit1.compare(boxFruit2));
        boxFruit1.pour(boxFruit2);
        System.out.println("Contents of boxFruit1 after transfer: " + boxFruit1.getFruits());
        System.out.println("Weight of boxFruit1 after transfer = " + boxFruit1.weight());
        System.out.println("Contents of boxFruit2 after transfer: " + boxFruit2.getFruits());
        System.out.println("Weight of boxFruit2 box after transfer = " + boxFruit2.weight());
        System.out.println();
        System.out.println("=".repeat(30));
        Box<Apple> boxApple1 = new Box<>();
        boxApple1.addFruits(apple1);
        System.out.println("Contents of boxApple1: " + boxApple1.getFruits());
        System.out.println("Weight of boxApple1 = " + boxApple1.weight());
        Box<Apple> boxApple2 = new Box<>();
        boxApple2.addFruits(apple2);
        System.out.println("Contents of boxApple2: " + boxApple2.getFruits());
        System.out.println("Weight of boxApple2 = " + boxApple2.weight());
        System.out.println("Comparison of boxApple1 and boxApple2 boxes = " + boxApple1.compare(boxApple2));
        boxApple1.pour(boxApple2);
        System.out.println("Contents of boxApple1 after migration: " + boxApple1.getFruits());
        System.out.println("Weight of boxApple1 after transfer = " + boxApple1.weight());
        System.out.println("Contents of the boxApple2 after the transfer: " + boxApple2.getFruits());
        System.out.println("Weight of boxApple2 after transfer = " + boxApple2.weight());
        System.out.println();
        System.out.println("=".repeat(30));
        Box<Orange> boxOrange1 = new Box<>();
        boxOrange1.addFruits(orange1);
        System.out.println("Contents of boxOrange1: " + boxOrange1.getFruits());
        System.out.println("Weight of boxOrange1 = " + boxOrange1.weight());
        System.out.println("=".repeat(30));
        System.out.println("Contents of boxFruit1: " + boxFruit1.getFruits());
        boxFruit1.addFruits(orange1);
        System.out.println("Contents of boxFruit1 (MixedBox) after adding orange: " + boxFruit1.getFruits());
        System.out.println("Weight of boxFruit1 = " + boxFruit1.weight());
        boxFruit1.addFruits(apple1);
        System.out.println("Contents of boxFruit1 (MixedBox) after adding an apple: " + boxFruit1.getFruits());
        System.out.println("Weight of boxFruit1 = " + boxFruit1.weight());
    }
}
