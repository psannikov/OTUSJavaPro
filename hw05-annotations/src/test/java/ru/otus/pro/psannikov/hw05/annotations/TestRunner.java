package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    private final List<Method> befoMethods = new ArrayList<>();
    private final List<Method> afterMethods = new ArrayList<>();
    private final List<Method> testMethods = new ArrayList<>();
    private final List<Method> intersection = new ArrayList<>();
    private final CalculatorTest calculatorTest = new CalculatorTest();
    private final List<Method> successfulTest = new ArrayList<>();
    private final List<Method> unSuccessfulTest = new ArrayList<>();

    private void prepareMethodsArrays() {
        Class<?> clazz = calculatorTest.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof BeforeMethod) {
                    befoMethods.add(method);
                } else if (annotation instanceof AfterMethod) {
                    afterMethods.add(method);
                } else if (annotation instanceof Test) {
                    testMethods.add(method);
                }
            }
        }
        for (Method method : befoMethods) {
            if (afterMethods.contains(method)) {
                intersection.add(method);
            }
        }
        for (Method method : befoMethods) {
            if (testMethods.contains(method)) {
                intersection.add(method);
            }
        }
        for (Method method : testMethods) {
            if (afterMethods.contains(method)) {
                intersection.add(method);
            }
        }
    }

    private boolean checkHasErrorsInAnnotations() {
        return !intersection.isEmpty();
    }

    private void runAllTest() {
        if (!testMethods.isEmpty()) {
                for (Method testMethod : testMethods) {
                    try {
                    for (Method beforeMethod : befoMethods) {
                        beforeMethod.invoke(calculatorTest);
                    }
                    testMethod.invoke(calculatorTest);
                    successfulTest.add(testMethod);
                }
             catch (Exception e) {
                    System.out.println(e.getMessage());
                unSuccessfulTest.add(testMethod);
                }}
            try {
            for (Method afterMethod : afterMethods) {
                afterMethod.invoke(calculatorTest);
            } } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            }
        }

    public void unitTestRunner() {
        try {
            prepareMethodsArrays();
            if (checkHasErrorsInAnnotations()) {
                throw new IllegalArgumentException("Тест методы имеют более одной аннотации, необходимо исправить");
            }
            runAllTest();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Успешно пройденные тесты:" + successfulTest);
        System.out.println("Неуспешно пройденные тесты:" + unSuccessfulTest);
    }
}