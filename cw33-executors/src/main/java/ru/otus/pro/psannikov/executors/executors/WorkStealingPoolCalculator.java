package ru.otus.pro.psannikov.executors.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkStealingPoolCalculator {

    private static ExecutorService pool = Executors.newWorkStealingPool();
    private static List<Future<Long>> futureList = new ArrayList<>();

    public static long calculateWeight(Node node, int level) throws Exception {
        long sum = calculateWeightInner(node, level);
        for (Future<Long> future : futureList) {
            sum += future.get();
        }
        return sum;
    }

    private static long calculateWeightInner(Node node, int level) {
        if (level < 1) {
            futureList.add(pool.submit(() -> SimpleCalculator.calculateWeight(node)));
            return 0;
        }

        long sum = node.getWeight();

        if (node.getLeftNode() != null) {
            sum += calculateWeightInner(node.getLeftNode(), level - 1);
        }

        if (node.getRightNode() != null) {
            sum += calculateWeightInner(node.getRightNode(), level - 1);
        }
        return sum;
    }
}
