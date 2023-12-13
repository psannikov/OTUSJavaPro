package ru.otus.pro.psannikov.hw06.solid.domain;

import java.util.List;

public class Bill {
    private final String name;
    private List<Integer> valNotes;

    public Bill(String name, List<Integer> valNotes) {
        this.name = name;
        this.valNotes = valNotes;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getValNotes() {
        return valNotes;
    }
}
