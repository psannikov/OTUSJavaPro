package ru.otus.pro.psannikov.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        int ctr = 0;

        while (true) {
            try (
                    Socket server = new Socket("localhost", 5555);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(server.getOutputStream()))
            ) {

                writer.println("Client request " + (++ ctr));
                writer.flush();
                System.out.println(reader.readLine());
                Thread.sleep(2000);

            } catch (Exception ex) {
                Thread.sleep(2000);
                ex.printStackTrace();
            }
        }

    }
}
