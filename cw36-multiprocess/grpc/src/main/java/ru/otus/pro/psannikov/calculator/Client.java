package ru.otus.pro.psannikov.calculator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class Client {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        CalculatorGrpc.CalculatorStub stub = CalculatorGrpc.newStub(channel);

        CalcRequest request = CalcRequest.newBuilder()
                .setSummand1(2)
                .setSummand2(4)
                .build();

        CountDownLatch latch = new CountDownLatch(1);

        System.out.println(Thread.currentThread().getName());

        stub.add(request, new StreamObserver<CalcResponse>() {
            @Override
            public void onNext(CalcResponse value) {
                System.out.println(value.getResult() + " " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        latch.await();
    }
}