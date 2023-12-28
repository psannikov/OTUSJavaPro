package ru.otus.pro.psannikov.hw08.serialization.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YAML implements Parser{
    final private String fileName;
    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory()).findAndRegisterModules();
    public YAML(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeToFile(List<Message> list) throws IOException {
        File yamlFile = new File(fileName);
        mapper.writeValue(yamlFile, list);
    }

    @Override
    public List<Message> readFromFile() throws IOException {
        List<Message> messages = new ArrayList<>();
        File yamlFile = new File(fileName);
        JsonNode root = mapper.readTree(yamlFile);
        if (root.isArray()) {
            for (JsonNode messageItem : root) {
                Message message = mapper.treeToValue(messageItem, Message.class);
                messages.add(message);
            }
        }
        return messages;
    }
}
