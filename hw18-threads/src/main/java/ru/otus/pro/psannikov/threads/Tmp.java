package ru.otus.pro.psannikov.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmp {
    private static final Lock lock = new ReentrantLock();
    private static final Condition possibleToThread1 = lock.newCondition();
    private static final Condition possibleToThread2 = lock.newCondition();

    private static long cnt=0;
    private static int iterThread1 = 1;
    private static int iterThread2 = 1;
    public static void printNumbs() throws InterruptedException {
        Runnable runnable = () -> {
            while (cnt < 50) {
                if (cnt % 2 == 0) {
                    System.out.print(Thread.currentThread().getName() + ": " + iterThread1);
                    iterThread1++;
                } else if (cnt % 2 == 1) {
                    System.out.print(Thread.currentThread().getName() + ": " + iterThread2);
                    iterThread2++;
                }
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

    public static void main(String[] args) throws InterruptedException {
        printNumbs();
    }
}
