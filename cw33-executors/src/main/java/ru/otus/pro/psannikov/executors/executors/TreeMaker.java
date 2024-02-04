package ru.otus.pro.psannikov.executors.executors;

import java.util.Random;

public class TreeMaker {

    private static Random random = new Random();
    private static long sum = 0;

    public static long createTree(Node root, int level) {
        root.setLeftNode(new Node());
        root.setRightNode(new Node());
        root.setWeight(random.nextInt(100));
        sum += root.getWeight();

        Node leftNode = root.getLeftNode();
        Node rightNode = root.getRightNode();

        if (level == 1) {
            leftNode.setWeight(random.nextInt(100));
            rightNode.setWeight(random.nextInt(100));
            sum += leftNode.getWeight() + rightNode.getWeight();
            return sum;
        }
        createTree(leftNode, level - 1);
        createTree(rightNode, level - 1);
        return sum;
    }
}
