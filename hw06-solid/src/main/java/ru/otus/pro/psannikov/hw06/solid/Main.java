package ru.otus.pro.psannikov.hw06.solid;

import ru.otus.pro.psannikov.hw06.solid.service.Bill;
import ru.otus.pro.psannikov.hw06.solid.service.CashMachineService;
import ru.otus.pro.psannikov.hw06.solid.service.MoneyBoxService;
import ru.otus.pro.psannikov.hw06.solid.service.impl.CashMachineServiceImpl;
import ru.otus.pro.psannikov.hw06.solid.service.impl.MoneyBoxServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Bill bill = new Bill("Рубль", 100, 500, 1000, 5000);
        MoneyBox moneyBox = new MoneyBox();
        CashMachine cashMachine = new CashMachine(moneyBox);
        MoneyBoxService moneyBoxService = new MoneyBoxServiceImpl(bill);
        BigDecimal amountToGet = BigDecimal.valueOf(44000);
        BigDecimal amountToGetBigger = BigDecimal.valueOf(440000000);
        BigDecimal amountToGetIllegal = BigDecimal.valueOf(159);
        BigDecimal amountToPut = BigDecimal.valueOf(400);
        List<Integer> notesToPut = Arrays.asList(0, 0, 0, 4);
        CashMachineService cashMachineService = new CashMachineServiceImpl(moneyBoxService);
        System.out.println("Денег в АТМ до снятия "+ amountToGet +": " + moneyBoxService.checkSum(moneyBox));
        List<Integer> takenAmount = cashMachineService.getMoney(cashMachine, amountToGet);
        System.out.println("Взяты купюры " + takenAmount);
        System.out.println("Денег в АТМ после снятия " + amountToGet + ": " + moneyBoxService.checkSum(moneyBox));
        System.out.println("Денег в АТМ до пополнения "+ amountToPut +": " + moneyBoxService.checkSum(moneyBox));
        cashMachineService.putMoney(cashMachine, notesToPut);
        System.out.println("Денег в АТМ после пополнения "+ amountToPut +": " + moneyBoxService.checkSum(moneyBox));
        System.out.println("Попытка снять больше чем есть в банкомате");
        try {
            cashMachineService.getMoney(cashMachine, amountToGetBigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Попытка снять сумму не кратную купюрам");
        try {
            cashMachineService.getMoney(cashMachine, amountToGetIllegal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
