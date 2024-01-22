package ru.otus.pro.psannikov.message;

import io.grpc.ServerBuilder;

public class Server {
    public static void main(String[] args) throws Exception{
        io.grpc.Server server = ServerBuilder
                .forPort(8081)
                .addService(new TestServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}