package ru.otus.pro.psannikov.hw08.serialization.parsed;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Json {
    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
    String fileName = "parse-json.json";
    File file = new File(fileName);
    public void writeToFile(List<Message> list) throws IOException {
        mapper.writeValue(file, list);
    }
    public String readFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
