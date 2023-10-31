package ru.otus.pro.psannikov.hw08.serialization.parsed;

import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaBin implements Parser{
    private String fileName;

    public JavaBin(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeToFile(List<Message> list) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
        }
    }

    @Override
    public List<Message> readFromFile() throws IOException {
        List<Message> messages = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            messages = (List<Message>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ClassNotFoundException");
        }
        return messages;
    }
}
