package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    FANTASY("Фэнтези"), SCIFI("Научная фантастика");
    private String name;
}
