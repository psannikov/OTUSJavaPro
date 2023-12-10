package ru.otus.pro.psannikov.webserver.cashmachine.bank.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.dao.CardsDao;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.data.Card;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.AccountService;
import ru.otus.pro.psannikov.webserver.cashmachine.bank.service.CardService;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Service
public class CardServiceImpl implements CardService {
    private final static String  cardNoFound = "No card found";
    AccountService accountService;

    CardsDao cardsDao;

    public CardServiceImpl(final AccountService accountService, final CardsDao cardsDao) {
        this.accountService = accountService;
        this.cardsDao = cardsDao;
    }

    @Override
    public Card createCard(String number, Long accountId, String pinCode) {
        return cardsDao.createCard(number, accountId, pinCode);
    }

    @Override
    public boolean cnangePin(String number, String oldPin, String newPin) {
        Card card = cardsDao.getCardByNumber(number);

        if (card == null) {
            throw new IllegalArgumentException(cardNoFound);
        }

        try {
            checkPin(card, oldPin);
            card.setPinCode(getHash(newPin));
            cardsDao.saveCard(card);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public BigDecimal getMoney(String number, String pin, BigDecimal sum) {
        Card card = cardsDao.getCardByNumber(number);

        if (card == null) {
            throw new IllegalArgumentException(cardNoFound);
        }

        checkPin(card, pin);
        return accountService.getMoney(card.getAccountId(), sum);
    }

    @Override
    public BigDecimal putMoney(String number, String pin, BigDecimal sum) {
        Card card = cardsDao.getCardByNumber(number);

        if (card == null) {
            throw new IllegalArgumentException(cardNoFound);
        }
        checkPin(card, pin);
        return accountService.putMoney(card.getAccountId(), sum);
    }

    @Override
    public BigDecimal getBalance(String number, String pin) {
        Card card = cardsDao.getCardByNumber(number);

        if (card == null) {
            throw new IllegalArgumentException(cardNoFound);
        }
        checkPin(card, pin);
        return accountService.checkBalance(card.getId());
    }

    private void checkPin(Card card, String pin) {
        if (!getHash(pin).equals(card.getPinCode())) {
            throw new IllegalArgumentException("Pincode is incorrect");
        }
    }

    private String getHash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.update(value.getBytes());
            return HexFormat.of().formatHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}