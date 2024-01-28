package ru.otus.pro.psannikov.executors.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private final Lock lock = new ReentrantLock();
    private final Condition possibleToPut = lock.newCondition();
    private final Condition possibleToGet = lock.newCondition();

    private final Good[] boxArray = new Good[50];
    private int count;

    public void put(Good good) {
        lock.lock();
        try {
            while (count == boxArray.length)  {
                System.out.println(Thread.currentThread().getName() + " : " + " добавить нельзя - все заполнено");
                possibleToPut.await();
            }
            boxArray[count] = good;
            count++;
            possibleToGet.signal();
            System.out.println(Thread.currentThread().getName() + " : " + " добавлен новый товар " + good.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Good get() {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + " получить нельзя - пусто");
                possibleToGet.await();
            }
            Good good = boxArray[count - 1];
            count--;
            possibleToPut.signal();
            System.out.println(Thread.currentThread().getName() + " : " + " получен новый товар " + good.getName());
            return good;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
