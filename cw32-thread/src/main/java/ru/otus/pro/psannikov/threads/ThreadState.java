package ru.otus.pro.psannikov.threads;

public class ThreadState {

    public static Thread t0;
    public static Thread t1;

    public static void main(String[] args) throws InterruptedException {
        simpleDemoSolution();
        mediumDemoSolution();
        hardDemoSolution();
    }

//    Задача: Необходимо распечатать статусы NEW, RUNNABLE, TERMINATED потока
    public static void simpleDemoTask() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        t0.start();
    }

    public static void simpleDemoSolution() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + " : я стартовал");
            System.out.println(thread.getName() + " : поток " + thread.getName() + " в статусе " + thread.getState());
        });

        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());

        t0.start();

        t0.join();
        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());
    }

    //    Задача: Необходимо распечатать статус TIME_WAITING потока
    public static void mediumDemoTask() {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        t0.start();
    }

    public static void mediumDemoSolution() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я заснул");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " : я проснулся");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t0.start();

        System.out.println(Thread.currentThread().getName() + " : я заснул");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " : я проснулся");
        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());
    }

//    Задача: Необходимо распечатать статус WAITING потока
    public static void hardDemoTask() {
        t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        t0.start();
        t1.start();
    }

    public static void hardDemoSolution() throws InterruptedException {
        t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я заснул");
                t1.start();
                Thread.sleep(7000);
                System.out.println(Thread.currentThread().getName() + " : я проснулся");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я приостановился в ожидании");
                t0.join();
                System.out.println(Thread.currentThread().getName() + " : я дождался");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t0.start();
        System.out.println(Thread.currentThread().getName() + " : я заснул");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " : я проснулся");

        System.out.println(Thread.currentThread().getName() + " : поток " + t1.getName() + " в статусе " + t1.getState());
    }

}
