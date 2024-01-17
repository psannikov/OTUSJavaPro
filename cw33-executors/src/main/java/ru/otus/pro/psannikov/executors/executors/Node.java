package ru.otus.pro.psannikov.executors.executors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    private Node leftNode;
    private Node rightNode;

    private long weight;
}
