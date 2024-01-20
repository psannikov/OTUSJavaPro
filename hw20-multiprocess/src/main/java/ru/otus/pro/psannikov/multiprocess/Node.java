package ru.otus.pro.psannikov.multiprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Node {
    private final String name;

    public Node(String name) {
        this.name = name;
    }

    public void processRequest(Socket clientSocket) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = input.readLine();

            String response = "Hello from " + name;

            output.println(response);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
