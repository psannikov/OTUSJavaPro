package ru.otus.pro.psannikov.multiprocess;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.List;

public class LoadBalancer {
    private final int LOAD_BALANCER_PORT = 8888;

    public LoadBalancer(List<Integer> portList) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(LOAD_BALANCER_PORT)
                .addService(new LoadBalancerServiceImpl(portList)).build();
        server.start();
        server.awaitTermination();
    }
}
