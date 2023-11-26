package ru.otus.pro.psannikov.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
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


@ComponentScan
@EnableAutoConfiguration
public class Main {
//    static AccountDao accountDao = new AccountDao();
//    static AccountService accountService;
//    static CardsDao cardsDao;
//    static CardService cardService;
//    static MoneyBoxService moneyBoxService;
//    static CashMachineService cashMachineService;
//    static {
//        accountService = new AccountServiceImpl(accountDao);
//        cardsDao = new CardsDao();
//        cardService = new CardServiceImpl(accountService, cardsDao);
//        moneyBoxService = new MoneyBoxServiceImpl();
//        cashMachineService = new CashMachineServiceImpl(cardService, accountService, moneyBoxService);
//    }
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        MoneyBox moneyBox = new MoneyBox();
//        CashMachine cashMachine = new CashMachine(moneyBox);

        SpringApplication.run(Main.class, args);
    }
}