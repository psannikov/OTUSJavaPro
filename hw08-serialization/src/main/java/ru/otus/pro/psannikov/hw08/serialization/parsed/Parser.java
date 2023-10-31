package ru.otus.pro.psannikov.hw08.serialization.parsed;

import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.IOException;
import java.util.List;

public interface Parser {
    void writeToFile(List<Message> list) throws IOException;
    List<Message> readFromFile() throws IOException;
}
