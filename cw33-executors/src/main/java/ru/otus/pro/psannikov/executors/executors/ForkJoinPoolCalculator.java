package ru.otus.pro.psannikov.executors.executors;

import lombok.AllArgsConstructor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolCalculator {

    public static long calculateWeight(Node root, int level) {
        return ForkJoinPool.commonPool().invoke(new CalculateTask(root, level));
    }

    @AllArgsConstructor
    private static class CalculateTask extends RecursiveTask<Long> {

        private Node node;
        private int level;

        @Override
        protected Long compute() {
            if (level == 0) {
                return SimpleCalculator.calculateWeight(node);
            }

            long sum = node.getWeight();
            CalculateTask task1 = null;
            CalculateTask task2 = null;

            if (node.getLeftNode() != null) {
                task1 = new CalculateTask(node.getLeftNode(), level - 1);
                task1.fork();
            }

            if (node.getRightNode() != null) {
                task2 = new CalculateTask(node.getRightNode(), level - 1);
                task2.fork();
            }

            if (task1 != null) {
                sum += task1.join();
            }

            if (task2 != null) {
                sum += task2.join();
            }
            return sum;
        }
    }
}
