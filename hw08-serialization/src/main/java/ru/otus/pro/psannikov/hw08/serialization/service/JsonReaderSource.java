package ru.otus.pro.psannikov.hw08.serialization.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReaderSource {
    final private List<Message> messages = new ArrayList<>();
    private final String fileNameToRead;

    public JsonReaderSource(String fileNameToRead) {
        this.fileNameToRead = fileNameToRead;
    }

    public List<Message> readJsonToList() {
        String chatIdentifier = "";
        String membersLast = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File jsonFile = new File(this.getClass().getClassLoader().getResource(this.fileNameToRead).getFile());
            JsonNode root = objectMapper.readTree(jsonFile);
            JsonNode chatSessions = root.get("chat_sessions");
            if (chatSessions.isArray()) {
                for (JsonNode session : chatSessions) {
                    chatIdentifier = session.get("chat_identifier").textValue();
                    JsonNode members = session.get("members");
                    if (members.isArray()) {
                        membersLast = members.get(0).get("last").textValue();
                    }
                    JsonNode messagesNode = session.get("messages");

                    if (messagesNode.isArray()) {
                        for (JsonNode messageNode : messagesNode) {
                            Message message = objectMapper.treeToValue(messageNode, Message.class);
                            message.setChatIdentifier(chatIdentifier);
                            message.setMembersLast(membersLast);
                            messages.add(message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return messages.stream()
                .distinct()
                .sorted(Comparator.comparing(Message::getSendDate))
                .collect(Collectors.toList());
    }
}
