package ru.otus.pro.psannikov.annotation.annotation;

import java.lang.annotation.*;

@Repeatable(CustomAnnotations.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int age() default 63;
    String[] letters();
}
