package ru.otus.pro.psannikov.executors.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {

    public static Callable<Long> task = () -> {
        long sum = 0;
        for (int i = 0; i < 100_000_000; i++) {
            sum++;
        }
//        Раскомментировать для cachedThreadPool
//        System.out.println(Thread.currentThread().getName() + " work done");
        return sum;
    };

    public static void main(String[] args) throws Exception {
        System.out.println("Доступное кол-во ядер " + Runtime.getRuntime().availableProcessors());
        System.out.print("SingleThreadExecutor ");
        poolDemo(Executors.newSingleThreadExecutor(), 800, task);
        System.out.print("FixedThreadPool ");
        poolDemo(Executors.newFixedThreadPool(12), 800, task);
        System.out.print("WorkStealingPool ");
        poolDemo(Executors.newWorkStealingPool(), 800, task);
        System.out.print("CachedThreadPool ");
        poolDemo(Executors.newCachedThreadPool(), 10, task);
        forkJoinPoolDemo();
    }

    private static void poolDemo(ExecutorService pool, int taskCount, Callable<Long> task) throws Exception {
        List<Future<Long>> futureList = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < taskCount; i++) {
            futureList.add(pool.submit(task));
        }

        for (Future<Long> future : futureList) {
            future.get();
        }
        long finish = System.currentTimeMillis();

//        Раскомментировать для cachedThreadPool
//        Пул создаст 2 новых потока для выполнения 2 этих задач после паузы
//        Future<Long> f11 = pool.submit(ExecutorsDemo.task);
//        Future<Long> f12 = pool.submit(ExecutorsDemo.task);
//        f11.get();
//        f12.get();
//        Thread.sleep(70000);
//        Future<Long> f13 = pool.submit(ExecutorsDemo.task);
//        Future<Long> f14 = pool.submit(ExecutorsDemo.task);
//        f13.get();
//        f14.get();

        System.out.println("Время выполнения (мс) : " + (finish - start));
//        Обязательно завершить пулы потока, иначе программа зависнет.
        pool.shutdown();
    }

    private static void forkJoinPoolDemo() throws Exception {
        Node root = new Node();
        long sum = TreeMaker.createTree(root, 25);
        System.out.println("Сгенерировано дерево общим весом sum = " + sum);


        long start1 = System.currentTimeMillis();
        long realSum1 = SimpleCalculator.calculateWeight(root);
        long finish1 = System.currentTimeMillis();
        System.out.println("Время однопоточно подсчета веса дерева (мс): " +
                (finish1 - start1) +" realSum = " + realSum1);

        long start2 = System.currentTimeMillis();
        long realSum2 = WorkStealingPoolCalculator.calculateWeight(root, 4);
        long finish2 = System.currentTimeMillis();
        System.out.println("Время многопоточного подсчета (WorkStealingPool) веса дерева (мс): " +
                (finish2 - start2) +" realSum = " + realSum2);

        long start3 = System.currentTimeMillis();
        long realSum3 = ForkJoinPoolCalculator.calculateWeight(root, 4);
        long finish3 = System.currentTimeMillis();
        System.out.println("Время многопоточного подсчета (ForkJoinPool) веса дерева (мс): " +
                (finish3 - start3) +" realSum = " + realSum3);
    }
}
