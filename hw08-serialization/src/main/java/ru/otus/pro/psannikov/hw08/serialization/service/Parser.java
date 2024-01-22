package ru.otus.pro.psannikov.hw08.serialization.service;

import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.IOException;
import java.util.List;

public interface Parser {
    void writeToFile(List<Message> list) throws IOException;
    List<Message> readFromFile() throws IOException;
}
