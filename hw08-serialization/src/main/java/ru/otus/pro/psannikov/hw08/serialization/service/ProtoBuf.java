package ru.otus.pro.psannikov.hw08.serialization.service;

import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.IOException;
import java.util.List;

public class ProtoBuf implements Parser {
    private String fileName;

    @Override
    public void writeToFile(List<Message> list) throws IOException {

    }

    @Override
    public List<Message> readFromFile() throws IOException {
        return null;
    }
}
