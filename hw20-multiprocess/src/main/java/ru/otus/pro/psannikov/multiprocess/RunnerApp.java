package ru.otus.pro.psannikov.multiprocess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RunnerApp {
    private final int NODECOUNT = 3;
    private int startPortNode = 8889;

    public void threadsWork() throws InterruptedException {
        List<Integer> portList = new ArrayList<>();
        for (int i = 0; i < NODECOUNT; i++) {
            portList.add(startPortNode);
            startPortNode++;
        }
        Iterator<Integer> iter = portList.iterator();
        Runnable startNode = () -> {
            try {
                Node node = new Node("Node " + ThreadLocalRandom.current().nextInt(0, 100), iter.next());
                Thread.sleep(2000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable startLoadBalancer = () -> {
            try {
                LoadBalancer loadBalancer = new LoadBalancer(portList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable startClient = () -> {
            Client client = new Client();
            client.sendMessages();
        };
        for (int i = 0; i < NODECOUNT; i++) {
            Thread threadNode = new Thread(startNode);
            threadNode.start();
        }
        Thread threadLoadBalancer = new Thread(startLoadBalancer);
        Thread.sleep(1000);
        Thread threadClient = new Thread(startClient);
        Thread.sleep(1000);
        threadLoadBalancer.start();
        Thread.sleep(1000);
        threadClient.start();
    }
}
