package ru.otus.pro.psannikov.generic;

public class ComparableBoxGeneric implements Comparable<ComparableBoxGeneric> {
    private int size;

    @Override
    public int compareTo(ComparableBoxGeneric o) {
        return this.size - o.size;
    }
}
