package ru.otus.pro.psannikov.hw06.solid.domain;

import java.util.List;

public class MoneyBox {
    private List<Integer> notes;

    public MoneyBox(List<Integer> notes) {
        this.notes = notes;
    }

    public List<Integer> getNotes() {
        return notes;
    }

    public void setNotes(int positionOfBox, int note) {
        this.notes.set(positionOfBox, note);
    }
}
