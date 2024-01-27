package ru.otus.pro.psannikov.hw08.serialization.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json implements Parser {
    final private String fileName;
    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    public Json(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<Message> list) throws IOException {
        File jsonFile = new File(fileName);
        mapper.writeValue(jsonFile, list);
    }

    public List<Message> readFromFile() throws IOException {
        List<Message> messages = new ArrayList<>();
        File jsonFile = new File(fileName);
        JsonNode root = mapper.readTree(jsonFile);
        if (root.isArray()) {
            for (JsonNode messageItem : root) {
                Message message = mapper.treeToValue(messageItem, Message.class);
                messages.add(message);
            }
        }
        return messages;
    }
}
