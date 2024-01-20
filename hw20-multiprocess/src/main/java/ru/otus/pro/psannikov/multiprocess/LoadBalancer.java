package ru.otus.pro.psannikov.multiprocess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LoadBalancer implements Runnable {
    private List<Node> nodes;
    private int current = 0;

    public LoadBalancer() {
        this.nodes = new ArrayList<>();
    }

    public synchronized void registerNode(Node node) {
        nodes.add(node);
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("LoadBalancer started on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                Node nextNode = getNextNode();

                Thread requestThread = new Thread(() -> {
                    nextNode.processRequest(clientSocket);
                });
                requestThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized Node getNextNode() {
        if (current >= nodes.size()) {
            current = 0;
        }
        Node nextNode = nodes.get(current);
        current++;
        return nextNode;
    }
}
