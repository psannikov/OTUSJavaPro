package ru.otus.pro.psannikov.multiprocess;

public class MainApp {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();
        Thread loadBalancerThread = new Thread(loadBalancer);
        loadBalancerThread.start();

        Node node1 = new Node("Node1");
        Node node2 = new Node("Node2");
        Node node3 = new Node("Node3");

        loadBalancer.registerNode(node1);
        loadBalancer.registerNode(node2);
        loadBalancer.registerNode(node3);

        Client client = new Client(loadBalancer);
        for (int i = 0; i < 10; i++) {
            client.send();
        }
    }
}
