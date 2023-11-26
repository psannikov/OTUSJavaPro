package ru.otus.pro.psannikov.webserver.cashmachine.bank.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.dao.AccountDao;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.data.Account;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.AccountService;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;

    public AccountServiceImpl(final AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account createAccount(BigDecimal amount) {
        Account newAccount = new Account(0, amount);
        return accountDao.saveAccount(newAccount);
    }

    @Override
    public Account getAccount(Long id) {
        return accountDao.getAccount(id);
    }

    @Override
    public BigDecimal getMoney(Long id, BigDecimal amount) {
        Account account = accountDao.getAccount(id);
        if (account.getAmount().subtract(amount).doubleValue() < 0) {
            throw new IllegalArgumentException("Not enough money");
        }
        account.setAmount(account.getAmount().subtract(amount));
        return account.getAmount();
    }

    @Override
    public BigDecimal putMoney(Long id, BigDecimal amount) {
        Account account = accountDao.getAccount(id);
        account.setAmount(account.getAmount().add(amount));
        return account.getAmount();
    }

    @Override
    public BigDecimal checkBalance(Long id) {
        Account account = accountDao.getAccount(id);
        return account.getAmount();
    }
}