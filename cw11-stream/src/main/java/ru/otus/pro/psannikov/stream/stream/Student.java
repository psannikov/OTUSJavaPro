package ru.otus.pro.psannikov.stream.stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int age;
    private final int course;
    private final double avgMark;
}
