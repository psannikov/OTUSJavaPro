package ru.otus.pro.psannikov.threads;

class AlternateNumbers implements Runnable {
    private static Object lock = new Object();
    private static int count = 1;
    private boolean isIncreasing;

    public AlternateNumbers(boolean isIncreasing) {
        this.isIncreasing = isIncreasing;
    }

    @Override
    public void run() {
        while (count <= 10 && count >= 1) {
            synchronized (lock) {
                if ((isIncreasing && count % 2 == 1) || (!isIncreasing && count % 2 == 0)) {
                    System.out.println("Thread " + Thread.currentThread().getId() + ": " + count);
                    if (isIncreasing) {
                        count++;
                    } else {
                        count--;
                    }
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new AlternateNumbers(true));
        Thread thread2 = new Thread(new AlternateNumbers(false));

        // Ensure thread1 starts first
        thread1.start();
        thread2.start();
    }
}

