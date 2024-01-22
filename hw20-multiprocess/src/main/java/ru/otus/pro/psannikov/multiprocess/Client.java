package ru.otus.pro.psannikov.multiprocess;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public final int LIMIT_OF_MESSAGE = 20;
    public final String LOAD_BALANCER_HOST = "localhost";
    private final int LOAD_BALANCER_PORT = 8888;

    public void sendMessages() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(LOAD_BALANCER_HOST, LOAD_BALANCER_PORT)
                .usePlaintext()
                .build();
        LoadBalancerServiceGrpc.LoadBalancerServiceBlockingStub stub
                = LoadBalancerServiceGrpc.newBlockingStub(channel);

        for (int i = 0; i < LIMIT_OF_MESSAGE; i++) {
            LoadBalancerResponse helloResponse = stub.send(LoadBalancerRequest.newBuilder()
                    .setRequest("Hello World")
                    .build());
            System.out.println(helloResponse.getResponse());
        }
        channel.shutdown();
    }
}
