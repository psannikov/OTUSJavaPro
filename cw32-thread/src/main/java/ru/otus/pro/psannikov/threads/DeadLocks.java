package ru.otus.pro.psannikov.threads;

public class DeadLocks {

    private static String o1 = "блокировка 1";
    private static String o2 = "блокировка 2";

    public static void main(String[] args) {
        Thread t0 = new Thread(() -> {
            try {
                todo(o1, o2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t1 = new Thread(() -> {
            try {
                todo(o2, o1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t0.start();
        t1.start();
    }

    private static void todo(Object resource1, Object resource2) throws InterruptedException {
        synchronized (resource1) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " : " + resource1 + " захвачена");
//            Взаимная блокировка может произойти и без ожидания
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " : " + resource2 + " захвачена");
            }
        }
    }
}
