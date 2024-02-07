package ru.otus.pro.psannikov.rmi;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int op1, int op2) {
        return op1 + op2;
    }
}