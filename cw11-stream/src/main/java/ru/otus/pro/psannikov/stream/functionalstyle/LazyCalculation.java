package ru.otus.pro.psannikov.stream.functionalstyle;

import java.util.function.Supplier;

public class LazyCalculation {

    public static void main(String[] args) {
        withoutLazy(heavyFunction());
        withLazy(() -> heavyFunction());
    }

    private static void withoutLazy(Integer integer) {
        boolean condition = getCondition();
        if (condition) {
            System.out.println(integer);
        }
    }

    private static void withLazy(Supplier func) {
        boolean condition = getCondition();
        if (condition) {
            System.out.println(func.get());
        }
    }

    private static boolean getCondition() {
        return false;
    }

    private static Integer heavyFunction() {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
