package ru.otus.pro.psannikov.cashmachine.bank.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import ru.otus.pro.psannikov.cashmachine.bank.dao.AccountDao;
import ru.otus.pro.psannikov.cashmachine.bank.data.Account;
import ru.otus.pro.psannikov.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


public class AccountServiceTest {

    AccountDao accountDao;

    AccountServiceImpl accountServiceImpl;
    BigDecimal initialAmount;
    Long id;
    Account testAccount;

    @BeforeEach
    void init() {
        initialAmount = BigDecimal.valueOf(100.0);
        id = 1L;
        accountDao = mock(AccountDao.class);
        accountServiceImpl = new AccountServiceImpl(accountDao);
        testAccount = new Account(id, initialAmount);
    }

    @Test
    void createAccountMock() {
        when(accountDao.saveAccount(any(Account.class))).thenReturn(testAccount);
        Account createdAccount = accountServiceImpl.createAccount(initialAmount);
        assertNotNull(createdAccount);
        assertEquals(id, createdAccount.getId());
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
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        BigDecimal amountAfterAdd = accountServiceImpl.putMoney(id, amountToAdd);
        assertEquals(initialAmount.add(amountToAdd), amountAfterAdd);
    }

    @Test
    void getSumSuccess() {
        BigDecimal amountToSub = BigDecimal.valueOf(25);
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        BigDecimal amountAfterSub = accountServiceImpl.getMoney(id, amountToSub);
        assertEquals(initialAmount.subtract(amountToSub), amountAfterSub);
    }
    @Test
    void getSumError() {
        BigDecimal amountToSub = BigDecimal.valueOf(125);
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        assertThrows(IllegalArgumentException.class, () -> {accountServiceImpl.getMoney(id, amountToSub);});
    }

    @Test
    void getAccount() {
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        assertEquals(testAccount, accountServiceImpl.getAccount(id));
    }

    @Test
    void checkBalance() {
        when(accountDao.getAccount(id)).thenReturn(testAccount);
        assertEquals(initialAmount, accountServiceImpl.checkBalance(id));
    }
}
