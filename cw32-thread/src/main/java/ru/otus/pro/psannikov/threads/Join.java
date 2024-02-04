package ru.otus.pro.psannikov.threads;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        joinDemo();
        daemonDemo();
    }

    public static void joinDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });

        for (int i = 0; i < 51; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

//        Если вызывать join() раньше, чем поток t перейдет в состояние RANNABLE, то он не сработает.
//        t0.join();

        t0.start();

//        Благодаря join() поток main досчитает до 50, потом подождет завершения потока t0, и потом досчитает до 100
        t0.join();

        for (int i = 51; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }

    public static void daemonDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });

//        Основной поток main не будет ожидать окончания выполнения фонового потока
        t0.setDaemon(true);

        t0.start();

//        Если сделать поток фоновым в состоянии RUNNABLE, будет исключение
//        t0.setDaemon(true);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
