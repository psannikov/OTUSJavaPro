package ru.otus.pro.psannikov.webserver;

import ru.otus.pro.psannikov.webserver.cashmachine.bank.dao.AccountDao;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.CardService;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.impl.AccountServiceImpl;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.impl.CardServiceImpl;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.data.MoneyBox;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.CashMachineService;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.MoneyBoxService;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.impl.CashMachineServiceImpl;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.impl.MoneyBoxServiceImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class MoneyBoxApp {
    static AccountDao accountDao = new AccountDao();

    static AccountService accountService;
    static CardsDao cardsDao;
    static CardService cardService;
    static MoneyBoxService moneyBoxService;
    static CashMachineService cashMachineService;


    static {
        accountService = new AccountServiceImpl(accountDao);
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

        cashMachineService.changePin("1111", "0000", "0001");

        System.out.println("");
    }
}