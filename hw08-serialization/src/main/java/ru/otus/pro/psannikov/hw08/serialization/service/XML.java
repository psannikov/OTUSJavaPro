package ru.otus.pro.psannikov.hw08.serialization.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XML implements Parser{
    final private String fileName;
    final private XmlMapper mapper = (XmlMapper) new XmlMapper().findAndRegisterModules();


    public XML(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<Message> list) throws IOException {
        File file = new File(fileName);
        mapper.writeValue(file, list);
    }
    public List<Message> readFromFile() throws IOException {
        List<Message> messages = new ArrayList<>();
        File xmlFile = new File(fileName);
        JsonNode root = mapper.readTree(xmlFile);
        for (JsonNode messageItem : root.path("item")) {
            Message message = mapper.treeToValue(messageItem, Message.class);
            messages.add(message);
        }
        return messages;
    }
}
