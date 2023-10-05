package ru.otus.pro.psannikov.hw06.solid.service;

import ru.otus.pro.psannikov.hw06.solid.MoneyBox;

import java.util.List;


public interface MoneyBoxService {

    int checkSum(MoneyBox moneyBox);

    void putMoney(MoneyBox moneyBox, int note100, int note500, int note1000, int note5000);

    List<Integer> getMoney(MoneyBox moneyBox, int sum);

}