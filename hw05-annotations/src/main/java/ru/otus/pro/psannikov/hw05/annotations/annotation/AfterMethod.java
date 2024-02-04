package ru.otus.pro.psannikov.hw05.annotations.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterMethod {
}
