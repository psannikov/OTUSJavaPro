package ru.otus.pro.psannikov.calculator;

import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorGrpc.CalculatorImplBase {
    @Override
    public void add(CalcRequest request, StreamObserver<CalcResponse> responseObserver) {
        System.out.println("Income " + request.getSummand1() + " " + request.getSummand2());

        for (int i = 0; i < 30;  i ++ ) {

            CalcResponse response = CalcResponse.newBuilder()
                    .setResult(request.getSummand1() + request.getSummand2() + i)
                    .build();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }
}
