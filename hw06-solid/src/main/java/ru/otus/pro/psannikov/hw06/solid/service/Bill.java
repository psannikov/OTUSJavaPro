package ru.otus.pro.psannikov.hw06.solid.service;

public class Bill {
    private final String name;
    private final int valNote1;
    private final int valNote2;
    private final int valNote3;
    private final int valNote4;
    public Bill(String name, int valNote1, int valNote2, int valNote3, int valNote4) {
        this.name = name;
        this.valNote1 = valNote1;
        this.valNote2 = valNote2;
        this.valNote3 = valNote3;
        this.valNote4 = valNote4;
    }

    public String getName() {
        return name;
    }

    public int getValNote1() {
        return valNote1;
    }

    public int getValNote2() {
        return valNote2;
    }

    public int getValNote3() {
        return valNote3;
    }

    public int getValNote4() {
        return valNote4;
    }
}
