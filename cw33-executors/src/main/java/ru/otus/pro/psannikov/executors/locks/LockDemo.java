package ru.otus.pro.psannikov.executors.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static int count;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        lockDemo();
        tryLockDemo();
    }

    public static void lockDemo() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    count++;
                } finally {
//        Блокировку необходимо обязательно освободить!
                    lock.unlock();
                }
            }
        };

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);

        t0.start();
        t1.start();

        t0.join();
        t1.join();

        System.out.println(count);
    }

    public static void tryLockDemo() {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                long n = 0;
                while (!lock.tryLock()) {
//        Добавляем счетчик, чтобы понять, сколько раз поток безуспешно пытался захватить блокировку
                    n++;
                }
                try {
                    System.out.println(Thread.currentThread().getName() + " : " + i + " n=:" + n);
                } finally {
//        Блокировку необходимо обязательно освободить!
                    lock.unlock();
                }
            }
        };

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);

        t0.start();
        t1.start();
    }
}
