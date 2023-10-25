package ru.otus.pro.psannikov.hw08.serialization;

import ru.otus.pro.psannikov.hw08.serialization.parsed.Json;
import ru.otus.pro.psannikov.hw08.serialization.parsed.XML;
import ru.otus.pro.psannikov.hw08.serialization.source.JsonReaderSource;
import ru.otus.pro.psannikov.hw08.serialization.source.Message;

import java.io.IOException;
import java.util.List;

public class MainApp {
    /*
    Сериализовать полученные данные и записать их в файл (текстовой или бинарный)
    Десериализовать полученные данный и вывести результат на консоль
    Обязательно (текстовой): json, xml, csv, yml (можно использовать любой вреймворк)
    Дополнительно (бинарный): PrtotoBuf, Java Serialization*/
    public static void main(String[] args) throws IOException {
        String fileNameToRead = "sms.json";
        JsonReaderSource json = new JsonReaderSource(fileNameToRead);
        List<Message> messages = json.readJsonToList();
        System.out.println("=".repeat(30));
        for (Message message : messages) {
            System.out.println(message);
        }
        System.out.println("=".repeat(30));
        Json jsonParse = new Json();
        jsonParse.writeToFile(messages);
        String jsonParseString = jsonParse.readFromFile();
        System.out.println(jsonParseString);
        System.out.println("=".repeat(30));
        XML xmlParse = new XML();
        xmlParse.writeToFile(messages);
        String xmlParseString = xmlParse.readFromFile();
        System.out.println(xmlParseString);
    }
}
