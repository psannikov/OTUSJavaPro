package ru.otus.pro.psannikov.hw05.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    private final List<Method> befoMethods = new ArrayList<>();
    private final List<Method> afterMethods = new ArrayList<>();
    private final List<Method> testMethods = new ArrayList<>();
    private final List<Method> intersection = new ArrayList<>();
    private final CalculatorTest calculatorTest = new CalculatorTest();
    private final List<Method> successfulTest = new ArrayList<>();
    private final List<Method> unSuccessfulTest = new ArrayList<>();

    public CalculatorTest getCalculatorTest() {
        return calculatorTest;
    }

    public void addBefoMethods(Method method) {
        befoMethods.add(method);
    }

    public void addAfterMethods(Method method) {
        afterMethods.add(method);
    }

    public void addTestMethods(Method method) {
        testMethods.add(method);
    }

    public void addIntersection(Method method) {
        intersection.add(method);
    }

    public List<Method> getBefoMethods() {
        return befoMethods;
    }

    public List<Method> getAfterMethods() {
        return afterMethods;
    }

    public List<Method> getTestMethods() {
        return testMethods;
    }

    public List<Method> getIntersection() {
        return intersection;
    }

    public void addSuccessfulTest(Method method) {
        successfulTest.add(method);
    }

    public void addUnSuccessfulTest(Method method) {
        unSuccessfulTest.add(method);
    }

    public List<Method> getSuccessfulTests() {
        return successfulTest;
    }

    public List<Method> getUnSuccessfulTests() {
        return unSuccessfulTest;
    }
}