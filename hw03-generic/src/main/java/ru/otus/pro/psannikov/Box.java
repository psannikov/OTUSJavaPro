package ru.otus.pro.psannikov;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    ArrayList<T> fruits;
    private boolean isMixedBox = false;

    public Box(boolean isMixedBox ,T... fruits) {
        this.isMixedBox = isMixedBox;
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruits(T...fruits) {
        ArrayList<T> fruitsToAdd = new ArrayList<>(Arrays.asList(fruits));
        if (this.isMixedBox) {
            this.fruits.addAll(fruitsToAdd);
        } else {
            if ((this.fruits.isEmpty()) || (!this.fruits.isEmpty() && (this.fruits.get(0).getClass() == fruitsToAdd.get(0).getClass()))) {
                this.fruits.addAll(fruitsToAdd);
            } else {
                throw new RuntimeException("You can't put another fruit in the box");
            }
        }
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
        for (T fruit: this.fruits) {
            otherBox.addFruits(fruit);
        }
        this.fruits.clear();
    }
}
