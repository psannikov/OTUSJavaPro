package ru.otus.pro.psannikov.cw13.behavioral_patterns.state.data;

import java.math.BigDecimal;

public class OrderItem {
    private BigDecimal cost;
    private String name;

    public OrderItem(final BigDecimal cost, final String name) {
        this.cost = cost;
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
