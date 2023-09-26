package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.TestMethod;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    private int a;
    private int b;
    @BeforeMethod
    public void beforeTest () {
        a = 2;
        b = 3;
    }
    @AfterMethod
    public void afterTest () {

    }
    @TestMethod
    public void testSumm (int a, int b) {
        if (!(Calculator.summ(a,b) == a + b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов");
        }
    }
    @TestMethod
    public void testMultiplication () {
        if (!(Calculator.summ(a,b) == a * b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов");
        }
    }

}
