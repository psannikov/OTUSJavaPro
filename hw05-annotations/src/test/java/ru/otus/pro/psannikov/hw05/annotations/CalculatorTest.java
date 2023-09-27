package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.Test;

public class CalculatorTest {
    private final int a = 2;
    private final int b = 3;
    @BeforeMethod
    public void beforeTest () {
        System.out.println("Начинаем тест");
    }
    @AfterMethod
    public void afterTest () {
        System.out.println("Завершаем тест");
    }
    @Test
    public void testSumm () {
        if (!(Calculator.summ(a,b) == a + b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов сложения");
        }
    }
    @Test
    public void testMultiplication () {
        if (!(Calculator.multiplication(a,b) == a * b)) {
            throw new IllegalArgumentException("Некорректный результат расчетов сложения");
        }
        }
    }
