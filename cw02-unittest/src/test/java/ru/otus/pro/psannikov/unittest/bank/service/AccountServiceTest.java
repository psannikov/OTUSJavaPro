package ru.otus.pro.psannikov.unittest.bank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.data.Account;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {
    AccountService accountService;
    Account testAccount;

    @BeforeEach
    void init() {
        accountService = new AccountServiceImpl();
        testAccount = accountService.createAccount(new BigDecimal(1000));
    }

    @Test
    void createAccount() {
        Account newAccount = accountService.createAccount(new BigDecimal(1000));
        assertEquals(0, new BigDecimal(1000).compareTo(newAccount.getAmount()));
    }

    @Test
    void addSum() {
        BigDecimal sum = testAccount.getAmount();
        BigDecimal newSum = accountService.putMoney(testAccount.getId(), new BigDecimal(100));

        BigDecimal expectedSum = sum.add(new BigDecimal(100));
        assertEquals(0, expectedSum.compareTo(accountService.checkBalance(testAccount.getId())));
    }

    @Test
    void getSum() {
        BigDecimal sum = testAccount.getAmount();
        BigDecimal newSum = accountService.getMoney(testAccount.getId(), new BigDecimal(100));

        BigDecimal expectedSum = sum.subtract(new BigDecimal(100));
        assertEquals(0, expectedSum.compareTo(accountService.checkBalance(testAccount.getId())));
    }

    @Test
    void getAccount() {
        assertEquals(testAccount, accountService.getAccount(testAccount.getId()));
    }

    @Test
    void checkBalance() {
        assertEquals(0, testAccount.getAmount()
                .compareTo(accountService.checkBalance(testAccount.getId())));
    }
}
