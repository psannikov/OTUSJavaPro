package ru.otus.pro.psannikov.hw06.solid.service.impl;

import ru.otus.pro.psannikov.hw06.solid.domain.CashMachine;
import ru.otus.pro.psannikov.hw06.solid.service.CashMachineService;
import ru.otus.pro.psannikov.hw06.solid.service.MoneyBoxService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashMachineServiceImpl implements CashMachineService {

    private final MoneyBoxService moneyBoxService;

    public CashMachineServiceImpl(MoneyBoxService moneyBoxService) {
        this.moneyBoxService = moneyBoxService;
    }

    @Override
    public List<Integer> getMoney(CashMachine machine, BigDecimal amount) {
        try {
            return moneyBoxService.getMoney(machine.getMoneyBox(), amount.intValue());
        } catch (Exception e) {
            throw new RuntimeException("Cash withdrawal error. Try again");
        }
    }

    @Override
    public void putMoney(CashMachine machine, List<Integer> notes) {
        List<Integer> arrangedNotes = new ArrayList<>(notes);
        for (int i = 0; i < 4 - arrangedNotes.size(); i++) {
            arrangedNotes.add(0);
        }
        moneyBoxService.putMoney(machine.getMoneyBox(), arrangedNotes);
    }
}
