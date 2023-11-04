package ru.otus.pro.psannikov.hw06.solid.service;

import ru.otus.pro.psannikov.hw06.solid.domain.MoneyBox;

import java.util.List;

public interface MoneyBoxService {

    int checkSum(MoneyBox moneyBox);

    void putMoney(MoneyBox moneyBox, List<Integer> notes);

    List<Integer> getMoney(MoneyBox moneyBox, int sum);
}