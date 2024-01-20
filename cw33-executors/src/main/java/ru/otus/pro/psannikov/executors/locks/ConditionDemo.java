package ru.otus.pro.psannikov.executors.locks;

import java.util.Arrays;

public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Good[] vegetables = new Good[100];
        Good[] fruits = new Good[100];
        for (int i = 0; i < 100 ; i++) {
            vegetables[i] = new Good("Овощ-" + i);
            fruits[i] = new Good("Фрукт-" + i);
        }

        Good[] goods = new Good[200];

        Thread vegetablesProducer = new Thread(() -> Arrays.stream(vegetables).forEach(store::put));
        vegetablesProducer.setName("vegetablesProducer");

        Thread fruitsProducer = new Thread(() -> Arrays.stream(fruits).forEach(store::put));
        fruitsProducer.setName("fruitsProducer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                goods[i] = store.get();
            }
        });
        consumer.setName("Consumer");

        vegetablesProducer.start();
        fruitsProducer.start();
        consumer.start();

        vegetablesProducer.join();
        fruitsProducer.join();
        consumer.join();

        System.out.println(Thread.currentThread().getName() + " перегрузка закончена");
        Arrays.stream(goods)
                .forEach(good -> System.out.println(Thread.currentThread().getName() + " : " + good.getName()));
    }
}
