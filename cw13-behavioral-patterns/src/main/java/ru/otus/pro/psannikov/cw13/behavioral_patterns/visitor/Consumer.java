package ru.otus.pro.psannikov.cw13.behavioral_patterns.visitor;

public interface Consumer {
    void accept(ConsumerVisitor visitor);
}
