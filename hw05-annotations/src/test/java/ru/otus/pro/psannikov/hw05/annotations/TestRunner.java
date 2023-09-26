package ru.otus.pro.psannikov.hw05.annotations;

import ru.otus.pro.psannikov.hw05.annotations.annotation.AfterMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.BeforeMethod;
import ru.otus.pro.psannikov.hw05.annotations.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        List<Method> befoMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        System.out.println("=".repeat(30));
        Class<?> clazz = CalculatorTest.class;
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
        List<Method> intersection = new ArrayList<>();
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
        System.out.println(intersection);
    }
}
