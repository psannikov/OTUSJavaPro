package ru.otus.pro.psannikov.executors.executors;

public class SimpleCalculator {

    private SimpleCalculator() {}

    public static long calculateWeight(Node root) {
        long leftWeight = (root.getLeftNode() == null) ? 0 : calculateWeight(root.getLeftNode());
        long rightWeight = (root.getRightNode() == null) ? 0 : calculateWeight(root.getRightNode());
        return root.getWeight() + leftWeight + rightWeight;
    }
}
