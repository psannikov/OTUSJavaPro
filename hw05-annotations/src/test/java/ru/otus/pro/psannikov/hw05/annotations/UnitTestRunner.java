package ru.otus.pro.psannikov.hw05.annotations;

public class UnitTestRunner {
    public static void main(String[] args) {
        TestData testData = new TestData();
        TestRunner testRunner = new TestRunner();
        testRunner.unitTestRunner(testData);
    }
}
