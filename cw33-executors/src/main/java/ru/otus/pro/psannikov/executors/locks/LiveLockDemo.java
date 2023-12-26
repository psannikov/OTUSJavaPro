package ru.otus.pro.psannikov.executors.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockDemo {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t0 = new Thread(() -> {
            try {
                operation1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t1 = new Thread(() -> {
            try {
                operation2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t0.start();
        t1.start();
    }

    private static void operation1() throws InterruptedException {
        while (true) {
            lock1.tryLock();
            System.out.println(Thread.currentThread().getName() + " : lock1 захвачена, попытка получить lock2");
            Thread.sleep(100);

            if (lock2.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " : lock2 захвачена");
            } else {
                System.out.println(Thread.currentThread().getName() + " : не возможно захватить lock2, освобождаю lock1");
                lock1.unlock();
                continue;
            }

            System.out.println(Thread.currentThread().getName() + " : выполнение первой операции");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    private static void operation2() throws InterruptedException {
        while (true) {
            lock2.tryLock();
            System.out.println(Thread.currentThread().getName() + " : lock2 захвачена, попытка хахватить lock1");
            Thread.sleep(100);

            if (lock1.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " : lock1 захвачена");
            } else {
                System.out.println(Thread.currentThread().getName() + " : не возможно захватить lock1, освобождаю lock2");
                lock2.unlock();
                continue;
            }

            System.out.println(Thread.currentThread().getName() + " : выполнение второй операции");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
