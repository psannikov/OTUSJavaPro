package ru.otus.pro.psannikov.calculator;

import io.grpc.ServerBuilder;

public class Server {
    public static void main(String[] args) throws Exception {
        io.grpc.Server server = ServerBuilder
                .forPort(8081)
                .addService(new CalculatorServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
