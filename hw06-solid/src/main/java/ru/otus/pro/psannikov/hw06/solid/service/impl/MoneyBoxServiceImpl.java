package ru.otus.pro.psannikov.hw06.solid.service.impl;

import ru.otus.pro.psannikov.hw06.solid.MoneyBox;
import ru.otus.pro.psannikov.hw06.solid.service.MoneyBoxService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoneyBoxServiceImpl implements MoneyBoxService {
    private int valNote100 = 100;
    private int valNote500 = 500;
    private int valNote1000 = 1000;
    private int valNote5000 = 5000;


    @Override
    public int checkSum(MoneyBox moneyBox) {
        return moneyBox.getNote100() * valNote100 + moneyBox.getNote500() * valNote500 + moneyBox.getNote1000() * valNote1000 + moneyBox.getNote5000() * valNote5000;
    }

    @Override
    public void putMoney(MoneyBox moneyBox, int note100, int note500, int note1000, int note5000) {
        if (moneyBox == null) {
            throw new IllegalStateException("No money box");
        }

        moneyBox.setNote100(moneyBox.getNote100() + note100);
        moneyBox.setNote500(moneyBox.getNote500() + note500);
        moneyBox.setNote1000(moneyBox.getNote1000() + note1000);
        moneyBox.setNote5000(moneyBox.getNote5000() + note5000);
    }

    @Override
    public List<Integer> getMoney(MoneyBox moneyBox, int sum) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        if (sum > checkSum(moneyBox)) {
            throw new IllegalStateException("Not enough money");
        }

        if (sum % valNote100 != 0) {
            throw new IllegalStateException("Can't charge the required sum");
        }

        int chargedNotes = 0;
        int requiredNotes = 0;

        if (sum >= valNote5000) {
            requiredNotes = sum / valNote5000;
            if (requiredNotes <= moneyBox.getNote5000()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote5000();
            }
            sum -= chargedNotes * valNote5000;
            result.set(0, chargedNotes);
        }

        if (sum >= valNote1000) {
            requiredNotes = sum / valNote1000;
            if (requiredNotes <= moneyBox.getNote1000()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote1000();
            }
            sum -= chargedNotes * valNote1000;
            result.set(1, chargedNotes);
        }

        if (sum >= valNote500) {
            requiredNotes = sum / valNote500;
            if (requiredNotes <= moneyBox.getNote500()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote500();
            }
            sum -= chargedNotes * valNote500;
            result.set(2, chargedNotes);
        }

        if (sum >= valNote100) {
            requiredNotes = sum / valNote100;
            if (requiredNotes <= moneyBox.getNote100()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote100();
            }
            sum -= chargedNotes * valNote100;
            result.set(3, chargedNotes);
        }

        if (sum > 0) {
            throw new IllegalStateException("Not enough notes");
        }

        moneyBox.setNote5000(moneyBox.getNote5000() - result.get(0));
        moneyBox.setNote1000(moneyBox.getNote1000() - result.get(1));
        moneyBox.setNote500(moneyBox.getNote500() - result.get(2));
        moneyBox.setNote100(moneyBox.getNote100() - result.get(3));

        return result;
    }
}