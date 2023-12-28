package ru.otus.pro.psannikov.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        printNumbs();

    }

    public static void printNumbs() throws InterruptedException {
        Runnable runnable = () -> {
            lock.lock();
            System.out.print(Thread.currentThread().getName() + ": ");
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + " ");
                }
                for (int i = 9; i >= 1; i--) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setName("Поток 1");
        Thread thread2 = new Thread(runnable);
        thread2.setName("Поток 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
