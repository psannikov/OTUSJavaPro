package ru.otus.pro.psannikov.hw06.solid;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger  = Logger.getLogger(Main.class.getName());
        List<Integer> defaultCountOfNotes = Arrays.asList(1000, 1000, 1000, 1000);
        BigDecimal amountToGet = BigDecimal.valueOf(44000);
        BigDecimal amountToPut = BigDecimal.valueOf(400);
        List<Integer> notesToPut = Arrays.asList(0, 0, 0, 4);
        List<Integer> valNotes = Arrays.asList(100, 500, 1000, 5000);
        Bill bill = new Bill("Рубль", valNotes);
        MoneyBox moneyBox = new MoneyBox(defaultCountOfNotes);
        CashMachine cashMachine = new CashMachine(moneyBox);
        MoneyBoxService moneyBoxService = new MoneyBoxServiceImpl(bill);
        CashMachineService cashMachineService = new CashMachineServiceImpl(moneyBoxService);
        logger .log(Level.INFO, "Денег в АТМ до снятия " + amountToGet + ": " + moneyBoxService.checkSum(moneyBox));
        List<Integer> takenAmount = cashMachineService.getMoney(cashMachine, amountToGet);
        logger .log(Level.INFO, "Взяты купюры " + takenAmount);
        logger .log(Level.INFO, "Денег в АТМ после снятия " + amountToGet + ": " + moneyBoxService.checkSum(moneyBox));
        logger .log(Level.INFO, "Денег в АТМ до пополнения " + amountToPut + ": " + moneyBoxService.checkSum(moneyBox));
        cashMachineService.putMoney(cashMachine, notesToPut);
        logger .log(Level.INFO, "Денег в АТМ после пополнения " + amountToPut + ": " + moneyBoxService.checkSum(moneyBox));
    }
}
