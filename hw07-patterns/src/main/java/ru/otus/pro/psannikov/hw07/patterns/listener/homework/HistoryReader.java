package ru.otus.pro.psannikov.hw07.patterns.listener.homework;

import ru.otus.pro.psannikov.hw07.patterns.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}
