package ru.otus.pro.psannikov.hw06.solid.service.impl;

import ru.otus.pro.psannikov.hw06.solid.domain.MoneyBox;
import ru.otus.pro.psannikov.hw06.solid.domain.Bill;
import ru.otus.pro.psannikov.hw06.solid.service.MoneyBoxService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoneyBoxServiceImpl implements MoneyBoxService {
    private Bill bill;
    public MoneyBoxServiceImpl(Bill bill) {
        this.bill = bill;
    };
    @Override
    public int checkSum(MoneyBox moneyBox) {
        return moneyBox.getNotes().get(0) * bill.getValNotes().get(0)
                + moneyBox.getNotes().get(1) * bill.getValNotes().get(1)
                + moneyBox.getNotes().get(2) * bill.getValNotes().get(2)
                + moneyBox.getNotes().get(3) * bill.getValNotes().get(3);
    }

    @Override
    public void putMoney(MoneyBox moneyBox, List<Integer> notes) {
        int note1 = notes.get(0);
        int note2 = notes.get(1);
        int note3 = notes.get(2);
        int note4 = notes.get(3);
        if (moneyBox == null) {
            throw new IllegalStateException("No money box");
        }
        moneyBox.setNotes(0, moneyBox.getNotes().get(0) + note1);
        moneyBox.setNotes(1, moneyBox.getNotes().get(1) + note2);
        moneyBox.setNotes(2, moneyBox.getNotes().get(2) + note3);
        moneyBox.setNotes(3, moneyBox.getNotes().get(3) + note4);
    }

    @Override
    public List<Integer> getMoney(MoneyBox moneyBox, int sum) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        if (sum > checkSum(moneyBox)) {
            throw new IllegalStateException("Not enough money");
        }

        if (sum % bill.getValNotes().get(0) != 0) {
            throw new IllegalStateException("Can't charge the required sum");
        }

        int chargedNotes = 0;
        int requiredNotes = 0;

        for (int i = bill.getValNotes().size() - 1; i >= 0; i--) {
            if (sum >= bill.getValNotes().get(i)) {
                requiredNotes = sum / bill.getValNotes().get(i);
                if (requiredNotes <= moneyBox.getNotes().get(i)) {
                    chargedNotes = requiredNotes;
                } else {
                    chargedNotes = moneyBox.getNotes().get(i);
                }
                sum -= chargedNotes * bill.getValNotes().get(i);
                result.set(i, chargedNotes);
            }
            moneyBox.setNotes(i,moneyBox.getNotes().get(i) - result.get(i));
        }

        if (sum > 0) {
            throw new IllegalStateException("Not enough notes");
        }

        return result;
    }
}