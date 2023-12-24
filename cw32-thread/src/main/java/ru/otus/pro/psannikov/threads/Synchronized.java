package ru.otus.pro.psannikov.threads;

public class Synchronized {

    public static int count1;
    public static int count2;
    public static int count3;
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        syncDemo();
        syncNotWorkDemo();
        syncMethodDemo();
    }

    private static void syncDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    count1++;
                }
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    count1++;
                }
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count1);
    }

    private static void syncNotWorkDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (new Object()) {
                    count2++;
                }
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (new Object()) {
                    count2++;
                }
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count2);
    }

    public static synchronized void increment() {
        count3++;
    }

    public static void syncMethodDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count3);
    }
}
