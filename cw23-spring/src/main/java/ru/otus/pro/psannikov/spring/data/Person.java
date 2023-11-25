package ru.otus.pro.psannikov.spring.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String address;

    public Person() {
    }

}
