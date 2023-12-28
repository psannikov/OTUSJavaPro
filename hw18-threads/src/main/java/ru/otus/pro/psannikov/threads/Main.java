package ru.otus.pro.psannikov.threads;

public class Main {
    private final Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        var printer = new Main();
        printer.go();

    }

    private void printNumbs() {
        synchronized (monitor) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            for (int i = 9; i >= 1; i--) {
                System.out.print(i + " ");
            }
        }
    }

    private void go() throws InterruptedException {
        Thread thread1 = new Thread(this::go);
        Thread thread2 = new Thread(this::go);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
