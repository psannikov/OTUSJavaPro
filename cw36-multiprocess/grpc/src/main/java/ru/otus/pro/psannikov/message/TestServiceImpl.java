package ru.otus.pro.psannikov.message;

import io.grpc.stub.StreamObserver;
import ru.otus.pro.psannikov.message.TestRequest;
import ru.otus.pro.psannikov.message.TestResponse;
import ru.otus.pro.psannikov.message.TestServiceGrpc;

public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {
    @Override
    public void test(TestRequest request, StreamObserver<TestResponse> responseObserver) {
        TestResponse response = TestResponse.newBuilder()
                .setGreeting(request.getFirstName() +  "-" + request.getLastName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
