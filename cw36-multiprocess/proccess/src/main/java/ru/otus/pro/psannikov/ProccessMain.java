package ru.otus.pro.psannikov;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ProccessMain {
    public static void main(String[] args) throws Exception{

        Process process = new ProcessBuilder("ls", "-l324")
                .directory(new File("."))
                .start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        reader.lines().forEach(System.out::println);
    }
}
