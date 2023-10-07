package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private TestData prepareMethodsArrays(TestData testData) {
        Class<?> clazz = testData.getCalculatorTest().getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof BeforeMethod) {
                    testData.addBefoMethods(method);
                } else if (annotation instanceof AfterMethod) {
                    testData.addAfterMethods(method);
                } else if (annotation instanceof Test) {
                    testData.addTestMethods(method);
                }
            }
        }
        for (Method method : testData.getBefoMethods()) {
            if (testData.getAfterMethods().contains(method)) {
                testData.addIntersection(method);
            }
        }
        for (Method method : testData.getBefoMethods()) {
            if (testData.getTestMethods().contains(method)) {
                testData.addIntersection(method);
            }
        }
        for (Method method : testData.getTestMethods()) {
            if (testData.getAfterMethods().contains(method)) {
                testData.addIntersection(method);
            }
        }
        return testData;
    }

    private boolean checkHasErrorsInAnnotations(TestData testData) {
        return !testData.getIntersection().isEmpty();
    }

    private void runAllTest(TestData testData) {
        if (!testData.getTestMethods().isEmpty()) {
            for (Method testMethod : testData.getTestMethods()) {
                try {
                    for (Method beforeMethod : testData.getBefoMethods()) {
                        beforeMethod.invoke(testData.getCalculatorTest());
                    }
                    testMethod.invoke(testData.getCalculatorTest());
                    testData.addSuccessfulTest(testMethod);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    testData.addUnSuccessfulTest(testMethod);
                }
            }
            try {
                for (Method afterMethod : testData.getAfterMethods()) {
                    afterMethod.invoke(testData.getCalculatorTest());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void unitTestRunner(TestData testData) {
        try {
            prepareMethodsArrays(testData);
            if (checkHasErrorsInAnnotations(testData)) {
                throw new IllegalArgumentException("Тест методы имеют более одной аннотации, необходимо исправить");
            }
            runAllTest(testData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Успешно пройденные тесты:" + testData.getSuccessfulTests());
        System.out.println("Неуспешно пройденные тесты:" + testData.getUnSuccessfulTests());
    }
}