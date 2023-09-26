package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @BeforeMethod
    public void beforeTest () {
        System.out.println("Начинаем тест");
    }
    @AfterMethod
    public void afterTest () {
        System.out.println("Завершаем тест");
    }
    @Test
    public void testSumm (int a, int b) {
        if (!(Calculator.summ(a,b) == a + b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов сложения");
        }
    }
    @Test
    public void testMultiplication (int a, int b) {
        if (!(Calculator.summ(a,b) == a * b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов умножения");
        }
    }

}
