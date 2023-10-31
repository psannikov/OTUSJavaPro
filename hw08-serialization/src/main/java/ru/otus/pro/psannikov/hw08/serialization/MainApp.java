package ru.otus.pro.psannikov.hw08.serialization;

import ru.otus.pro.psannikov.hw08.serialization.service.JavaBin;
import ru.otus.pro.psannikov.hw08.serialization.service.Json;
import ru.otus.pro.psannikov.hw08.serialization.service.XML;
import ru.otus.pro.psannikov.hw08.serialization.service.YAML;
import ru.otus.pro.psannikov.hw08.serialization.service.JsonReaderSource;
import ru.otus.pro.psannikov.hw08.serialization.domain.Message;

import java.io.IOException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws IOException {
        final String sourceJsonFileName = "sms.json";
        final String parsedJsonFileName = "json_parse.json";
        final String parsedXMLFileName = "xml-parse.xml";
        final String parsedYMLFileName = "yml-parse.yml";
        final String parsedJavaBinFileName = "java-bin-parse.bin";
        JsonReaderSource json = new JsonReaderSource(sourceJsonFileName);
        List<Message> messages = json.readJsonToList();
        System.out.println("=".repeat(30) + "Чтение исходного файла" +"=".repeat(30));
        for (Message message : messages) {
            System.out.println(message);
        }
        System.out.println("=".repeat(30) + "Чтение и запись в JSON" +"=".repeat(30));
        Json jsonParse = new Json(parsedJsonFileName);
        jsonParse.writeToFile(messages);
        List<Message> jsonParseList = jsonParse.readFromFile();
        System.out.println(jsonParseList);
        System.out.println("=".repeat(30) + "Чтение и запись в XML" +"=".repeat(30));
        XML xmlParse = new XML(parsedXMLFileName);
        xmlParse.writeToFile(messages);
        List<Message> xmlParseList = xmlParse.readFromFile();
        System.out.println(xmlParseList);
        System.out.println("=".repeat(30) + "Чтение и запись в YAML" +"=".repeat(30));
        YAML ymlParse = new YAML(parsedYMLFileName);
        ymlParse.writeToFile(messages);
        List<Message> yamlParseList = ymlParse.readFromFile();
        System.out.println(yamlParseList);
        System.out.println("=".repeat(30) + "Чтение и запись в JavaBin" +"=".repeat(30));
        JavaBin javaParse = new JavaBin(parsedJavaBinFileName);
        javaParse.writeToFile(messages);
        List<Message> javaParseList = javaParse.readFromFile();
        System.out.println(javaParseList);
    }
}
