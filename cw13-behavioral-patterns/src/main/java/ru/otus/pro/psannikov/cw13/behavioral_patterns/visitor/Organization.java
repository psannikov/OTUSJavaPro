package ru.otus.pro.psannikov.cw13.behavioral_patterns.visitor;

public class Organization implements Consumer {
    public void accept(ConsumerVisitor visitor) {
        visitor.visit(this);
    }
}
