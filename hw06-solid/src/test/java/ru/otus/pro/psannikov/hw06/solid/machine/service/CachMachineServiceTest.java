package ru.otus.pro.psannikov.hw06.solid.machine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pro.psannikov.hw06.solid.domain.Bill;
import ru.otus.pro.psannikov.hw06.solid.domain.CashMachine;
import ru.otus.pro.psannikov.hw06.solid.domain.MoneyBox;
import ru.otus.pro.psannikov.hw06.solid.service.CashMachineService;
import ru.otus.pro.psannikov.hw06.solid.service.MoneyBoxService;
import ru.otus.pro.psannikov.hw06.solid.service.impl.CashMachineServiceImpl;
import ru.otus.pro.psannikov.hw06.solid.service.impl.MoneyBoxServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CachMachineServiceTest {
    private CashMachine cashMachine;
    private CashMachineService cashMachineService;
    private Bill bill;
    private MoneyBox moneyBox;
    private MoneyBoxService moneyBoxService;
    @BeforeEach
    void init() {
        List<Integer> defaultCountOfNotes = Arrays.asList(1000, 1000, 1000, 1000);
        List<Integer> valNotes = Arrays.asList(100, 500, 1000, 5000);
        bill = new Bill("Рубль", valNotes);
        moneyBox = new MoneyBox(defaultCountOfNotes);
        cashMachine = new CashMachine(moneyBox);
        moneyBoxService = new MoneyBoxServiceImpl(bill);
        cashMachineService = new CashMachineServiceImpl(moneyBoxService);
    }
    @Test
    void getBiggerAmount() {
        BigDecimal amountToGetBigger = BigDecimal.valueOf(440000000);
        String expectMessage= "Cash withdrawal error. Try again";
        Exception exception = assertThrows(RuntimeException.class, () -> {
            cashMachineService.getMoney(cashMachine, amountToGetBigger);
        });
        assertEquals(expectMessage, exception.getMessage());
    }
}
