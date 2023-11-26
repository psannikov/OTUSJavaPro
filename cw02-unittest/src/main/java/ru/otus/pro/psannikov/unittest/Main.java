package ru.otus.pro.psannikov.unittest;

import ru.otus.pro.psannikov.unittest.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.CardService;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.impl.AccountServiceImpl;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.impl.CardServiceImpl;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.data.MoneyBox;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.service.CashMachineService;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.service.MoneyBoxService;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.service.impl.CashMachineServiceImpl;
import ru.otus.pro.psannikov.unittest.cashmachine.machine.service.impl.MoneyBoxServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class Main {
    static AccountService accountService = new AccountServiceImpl();
    static CardsDao cardsDao = new CardsDao();
    static CardService cardService = new CardServiceImpl(accountService, cardsDao);
    static MoneyBoxService moneyBoxService = new MoneyBoxServiceImpl();
    static CashMachineService cashMachineService = new CashMachineServiceImpl(cardService, accountService, moneyBoxService);


    static {
        accountService = new AccountServiceImpl();
        cardsDao = new CardsDao();
        cardService = new CardServiceImpl(accountService, cardsDao);
        moneyBoxService = new MoneyBoxServiceImpl();
        cashMachineService = new CashMachineServiceImpl(cardService, accountService, moneyBoxService);
    }

    public static void main(String[] args) {
        MoneyBox moneyBox = new MoneyBox();
        CashMachine cashMachine = new CashMachine(moneyBox);

        BigDecimal initialSum = cashMachineService.checkBalance(cashMachine, "1111", "0000");
        System.out.println("Initial sum " + initialSum);

        List<Integer> takenAmount = cashMachineService.getMoney(cashMachine, "1111", "0000", BigDecimal.valueOf(4000));
        System.out.println("Taken notes " + takenAmount);

        initialSum = cashMachineService.checkBalance(cashMachine, "1111", "0000");
        System.out.println("New sum " + initialSum);

        cashMachineService.putMoney(cashMachine, "1111", "0000", Arrays.asList(0, 0, 0, 1));
        initialSum = cashMachineService.checkBalance(cashMachine, "1111", "0000");
        System.out.println("New sum " + initialSum);
    }
}