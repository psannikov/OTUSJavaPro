package ru.otus.pro.psannikov.threads;

public class IncrementProblem {

    public static int count;

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count);
    }
}
