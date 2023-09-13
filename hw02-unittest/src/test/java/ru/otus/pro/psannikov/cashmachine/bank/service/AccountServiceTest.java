package ru.otus.pro.psannikov.cashmachine.bank.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import ru.otus.pro.psannikov.cashmachine.bank.dao.AccountDao;
import ru.otus.pro.psannikov.cashmachine.bank.data.Account;
import ru.otus.pro.psannikov.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


public class AccountServiceTest {

    AccountDao accountDao;

    AccountServiceImpl accountServiceImpl;
    BigDecimal initialAmount;
    Long id;

    @BeforeEach
    void init() {
        initialAmount = BigDecimal.valueOf(100.0);
        id = 1L;
        accountDao = mock(AccountDao.class);
        accountServiceImpl = new AccountServiceImpl(accountDao);
    }

    @Test
    void createAccountMock() {
        Account testAccount = new Account(1L, initialAmount);
        when(accountDao.saveAccount(any(Account.class))).thenReturn(testAccount);
        Account createdAccount = accountServiceImpl.createAccount(initialAmount);
        assertNotNull(createdAccount);
        assertEquals(1L, createdAccount.getId());
        assertEquals(initialAmount, createdAccount.getAmount());
    }

    @Test
    void createAccountCaptor() {
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        accountServiceImpl.createAccount(initialAmount);
        verify(accountDao, times(1)).saveAccount(accountCaptor.capture());
        Account capturedAccount = accountCaptor.getValue();
        assertNotNull(capturedAccount);
        assertEquals(initialAmount, capturedAccount.getAmount());
    }

    @Test
    void addSum() {
        BigDecimal amountToAdd = BigDecimal.valueOf(25);
        Account testAccount = new Account(1L, initialAmount);
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        BigDecimal amountAfterAdd = accountServiceImpl.putMoney(id, amountToAdd);
        assertEquals(initialAmount.add(amountToAdd), amountAfterAdd);
    }

    @Test
    void getSum() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void checkBalance() {
    }
}
