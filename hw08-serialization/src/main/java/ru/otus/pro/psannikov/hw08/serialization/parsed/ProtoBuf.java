package ru.otus.pro.psannikov.hw08.serialization.parsed;

import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.IOException;
import java.util.List;

public class ProtoBuf implements Parser{
    @Override
    public void writeToFile(List<Message> list) throws IOException {

    }

    @Override
    public List<Message> readFromFile() throws IOException {
        return null;
    }
}
