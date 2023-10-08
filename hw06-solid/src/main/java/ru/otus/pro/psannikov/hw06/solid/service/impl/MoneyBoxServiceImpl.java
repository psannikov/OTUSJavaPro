package ru.otus.pro.psannikov.hw06.solid.service.impl;

import ru.otus.pro.psannikov.hw06.solid.MoneyBox;
import ru.otus.pro.psannikov.hw06.solid.service.Bill;
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
        return moneyBox.getNote1() * bill.getValNote1() + moneyBox.getNote2() * bill.getValNote2() + moneyBox.getNote3() * bill.getValNote3() + moneyBox.getNote4() * bill.getValNote4();
    }

    @Override
    public void putMoney(MoneyBox moneyBox, int note1, int note2, int note3, int note4) {
        if (moneyBox == null) {
            throw new IllegalStateException("No money box");
        }

        moneyBox.setNote1(moneyBox.getNote1() + note1);
        moneyBox.setNote2(moneyBox.getNote2() + note2);
        moneyBox.setNote3(moneyBox.getNote3() + note3);
        moneyBox.setNote4(moneyBox.getNote4() + note4);
    }

    @Override
    public List<Integer> getMoney(MoneyBox moneyBox, int sum) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

        if (sum > checkSum(moneyBox)) {
            throw new IllegalStateException("Not enough money");
        }

        if (sum % bill.getValNote1() != 0) {
            throw new IllegalStateException("Can't charge the required sum");
        }

        int chargedNotes = 0;
        int requiredNotes = 0;

        if (sum >= bill.getValNote4()) {
            requiredNotes = sum / bill.getValNote4();
            if (requiredNotes <= moneyBox.getNote4()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote4();
            }
            sum -= chargedNotes * bill.getValNote4();
            result.set(0, chargedNotes);
        }

        if (sum >= bill.getValNote3()) {
            requiredNotes = sum / bill.getValNote3();
            if (requiredNotes <= moneyBox.getNote3()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote3();
            }
            sum -= chargedNotes * bill.getValNote3();
            result.set(1, chargedNotes);
        }

        if (sum >= bill.getValNote2()) {
            requiredNotes = sum / bill.getValNote2();
            if (requiredNotes <= moneyBox.getNote2()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote2();
            }
            sum -= chargedNotes * bill.getValNote2();
            result.set(2, chargedNotes);
        }

        if (sum >= bill.getValNote1()) {
            requiredNotes = sum / bill.getValNote1();
            if (requiredNotes <= moneyBox.getNote1()) {
                chargedNotes = requiredNotes;
            } else {
                chargedNotes = moneyBox.getNote1();
            }
            sum -= chargedNotes * bill.getValNote1();
            result.set(3, chargedNotes);
        }

        if (sum > 0) {
            throw new IllegalStateException("Not enough notes");
        }

        moneyBox.setNote4(moneyBox.getNote4() - result.get(0));
        moneyBox.setNote3(moneyBox.getNote3() - result.get(1));
        moneyBox.setNote2(moneyBox.getNote2() - result.get(2));
        moneyBox.setNote1(moneyBox.getNote1() - result.get(3));

        return result;
    }
}