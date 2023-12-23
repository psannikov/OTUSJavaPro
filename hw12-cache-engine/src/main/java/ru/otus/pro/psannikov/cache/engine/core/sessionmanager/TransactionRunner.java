package ru.otus.pro.psannikov.cache.engine.core.sessionmanager;

public interface TransactionRunner {

    <T> T doInTransaction(TransactionAction<T> action);
}
