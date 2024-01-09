package ru.otus.pro.psannikov.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Lock lock = new ReentrantLock();
    private static final Condition possibleToThread1 = lock.newCondition();
    private static final Condition possibleToThread2 = lock.newCondition();
    public static final String THREAD1NAME = "Thread 1";
    public static final String THREAD2NAME = "Thread 2";
    private static boolean firstRun = true;
    private final static int MAXITERATION = 100;


    public static void main(String[] args) throws InterruptedException {
        threadsWork();
    }
    public static void threadsWork() throws InterruptedException {
        Runnable runnable = () -> {
            int iteration = 0;
            Printer printer1 = new Printer();
            Printer printer2 = new Printer();
            while (iteration < MAXITERATION) {
                iteration++;
                lock.lock();
                try {
                    if (firstRun) {
                        firstRun = false;
                        possibleToThread1.signal();
                        possibleToThread2.await();
                    }
                    System.out.print(Thread.currentThread().getName() + " ");
                    if (Thread.currentThread().getName() == THREAD1NAME) {
                        printer1.printNumbers();
                        possibleToThread2.signal();
                        possibleToThread1.await();
                    } else if (Thread.currentThread().getName() == THREAD2NAME) {
                        printer2.printNumbers();
                        possibleToThread1.signal();
                        possibleToThread2.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setName(THREAD1NAME);
        Thread thread2 = new Thread(runnable);
        thread2.setName(THREAD2NAME);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
