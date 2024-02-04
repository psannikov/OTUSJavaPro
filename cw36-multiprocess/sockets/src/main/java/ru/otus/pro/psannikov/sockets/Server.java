package ru.otus.pro.psannikov.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5555);

        while (true) {
            executorService.submit(new ClientSocketHandler(serverSocket.accept()));
        }

    }

    private static class ClientSocketHandler implements Runnable{
        Socket clientSocket;

        public ClientSocketHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {

                try (
                        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
                ) {
                    System.out.print("Handler " + Thread.currentThread().getName());
                    System.out.println(reader.readLine());
                    writer.println("Accepted");
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

        }
    }

}
