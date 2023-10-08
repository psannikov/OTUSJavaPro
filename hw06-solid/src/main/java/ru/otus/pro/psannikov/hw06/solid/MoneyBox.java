package ru.otus.pro.psannikov.hw06.solid;

public class MoneyBox {
    private int note1;
    private int note2;
    private int note3;
    private int note4;

    public MoneyBox() {
        this(1000, 1000, 1000, 1000);
    }

    public MoneyBox(int note1, int note2, int note3, int note4) {
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
    }

    public int getNote1() {
        return note1;
    }

    public void setNote1(int note1) {
        this.note1 = note1;
    }

    public int getNote2() {
        return note2;
    }

    public void setNote2(int note2) {
        this.note2 = note2;
    }

    public int getNote3() {
        return note3;
    }

    public void setNote3(int note3) {
        this.note3 = note3;
    }

    public int getNote4() {
        return note4;
    }

    public void setNote4(int note4) {
        this.note4 = note4;
    }
}
