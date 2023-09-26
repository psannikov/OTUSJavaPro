package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.TestMethod;

public class TestRunner {
    public static void main(String[] args) {
        CalculatorTest calculatorTest = new CalculatorTest();
//        calculatorTest.testSumm(2,3);
        Class<CalculatorTest> cls = (Class<CalculatorTest>) calculatorTest.getClass();
        System.out.println(cls.getName());
        System.out.println("=".repeat(30));
        AfterMethod annAfter =cls.getAnnotation(AfterMethod.class);
        BeforeMethod annBefore =cls.getAnnotation(BeforeMethod.class);
        TestMethod annTest = cls.getAnnotation(TestMethod.class);
        System.out.println(annTest);
    }
}