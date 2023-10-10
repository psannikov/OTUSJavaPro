package ru.otus.pro.psannikov.hw06.solid.service;

import ru.otus.pro.psannikov.hw06.solid.domain.CashMachine;

import java.math.BigDecimal;
import java.util.List;

public interface CashMachineService {
    List<Integer> getMoney(CashMachine machine, BigDecimal amount);

    void putMoney(CashMachine machine, List<Integer> notes);

}
