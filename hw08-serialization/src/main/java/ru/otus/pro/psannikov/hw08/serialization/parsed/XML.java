package ru.otus.pro.psannikov.hw08.serialization.parsed;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XML {
    XmlMapper xmlMapper = (XmlMapper) new XmlMapper().findAndRegisterModules();
    String fileName = "parse-xml.xml";
    File file = new File(fileName);
    public void writeToFile(List<Message> list) {
        try {
            xmlMapper.writeValue(file, list);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String readFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
