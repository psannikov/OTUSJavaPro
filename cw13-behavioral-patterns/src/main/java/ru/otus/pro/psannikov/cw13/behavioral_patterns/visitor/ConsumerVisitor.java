package ru.otus.pro.psannikov.cw13.behavioral_patterns.visitor;

public interface ConsumerVisitor {
    void visit(Organization subject);
    void visit(Person subject);

}
