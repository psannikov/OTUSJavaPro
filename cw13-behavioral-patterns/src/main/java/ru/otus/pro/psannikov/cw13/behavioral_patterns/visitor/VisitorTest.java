package ru.otus.pro.psannikov.cw13.behavioral_patterns.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        test(new Organization());
        test(new Person());
    }

    public static void test(Consumer consumer) {
        ConsumerVisitor visitor = new ChargeVisitor();
        consumer.accept(visitor);
    }
}
