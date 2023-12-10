package ru.otus.pro.psannikov.unittest.cashmachine.bank.db;

import ru.otus.pro.psannikov.unittest.cashmachine.bank.data.Account;
import ru.otus.pro.psannikov.unittest.cashmachine.bank.data.Card;

import java.util.HashMap;
import java.util.Map;

public class Cards {
    public static Map<String, Card> cards = new HashMap<>();

    static {
        Account a1 = Accounts.accounts.get(1L);
        Account a2 = Accounts.accounts.get(2L);
        Account a3 = Accounts.accounts.get(3L);

        cards.put("1111", new Card(1, "1111", 1L, "0000"));
        cards.put("2222", new Card(2, "2222", 2L, "0000"));
        cards.put("3333", new Card(3, "3333", 3L, "0000"));
    }

    static Long idSequence = 10L;

    public static Long getNextId() {
        idSequence ++;
        return idSequence;
    }
}