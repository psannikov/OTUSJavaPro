package ru.otus.pro.psannikov.cw13.behavioral_patterns.visitor;

public class ChargeVisitor implements ConsumerVisitor{

    @Override
    public void visit(Organization subject) {
        System.out.println("Charged for organization");
    }

    @Override
    public void visit(Person subject) {
        System.out.println("Charged for person");
    }
}
