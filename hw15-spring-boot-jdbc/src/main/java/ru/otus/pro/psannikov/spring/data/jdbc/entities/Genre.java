package ru.otus.pro.psannikov.spring.data.jdbc.entities;

public enum Genre {
    FANTASY("Фэнтези"), SCIFI("Научная фантастика");

    private String name;

    public String getName() {
        return name;
    }

    Genre(String name) {
        this.name = name;
    }
}
