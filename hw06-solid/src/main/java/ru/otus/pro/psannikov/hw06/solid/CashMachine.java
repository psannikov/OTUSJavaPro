package ru.otus.pro.psannikov.hw06.solid;

public class CashMachine {
    private MoneyBox moneyBox;

    public CashMachine(MoneyBox moneyBox) {
        this.moneyBox = moneyBox;
    }

    public MoneyBox getMoneyBox() {
        return moneyBox;
    }

    public void setMoneyBox(MoneyBox moneyBox) {
        this.moneyBox = moneyBox;
    }
}
