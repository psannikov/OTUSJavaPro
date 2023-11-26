package ru.otus.pro.psannikov.proxy.lazy;

public interface HeavyObject {

    void init(String value);

    boolean isInit();

    String getValue();
}
