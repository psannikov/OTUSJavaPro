package ru.otus.pro.psannikov.hw03_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit>{
    private final List<T>  fruits;

    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<T> getFruits() {
        return fruits;
    }

    public void addFruits(T... fruits) {
        List<T> fruitsToAdd = new ArrayList<>(Arrays.asList(fruits));
        this.fruits.addAll(fruitsToAdd);
    }

    public int weight() {
        int result = 0;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    public boolean compare(Box <?> otherBox) {
        if (otherBox == null) {
            return false;
        }
        return this.weight() == otherBox.weight();
    }

    public void pour(Box <T> otherBox) {
        if (otherBox == null || this == otherBox) {} else {
            for (T fruit : this.fruits) {
                otherBox.addFruits(fruit);
            }
            this.fruits.clear();
        }
    }
}
