package ru.otus.pro.psannikov.multiprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final LoadBalancer loadBalancer;

    public Client(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public void send() {
        try {
            Socket loadBalancerSocket = new Socket("localhost", 8080);
            PrintWriter output = new PrintWriter(loadBalancerSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(loadBalancerSocket.getInputStream()));
            output.println("Hello");
            String response = input.readLine();
            System.out.println("Response from LoadBalancer: " + response);
            loadBalancerSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
