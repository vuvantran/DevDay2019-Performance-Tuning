package com.axonactive.devdayapp;

import static com.axonactive.devdayapp.grpc.HelloServiceGrpc.HelloServiceImplBase;
import static com.axonactive.devdayapp.grpc.HelloServiceOuterClass.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@org.lognet.springboot.grpc.GRpcService
public class GrpcEntryPoint extends HelloServiceImplBase {

    public void hello(com.axonactive.devdayapp.grpc.HelloServiceOuterClass.HelloRequest request,
        io.grpc.stub.StreamObserver<com.axonactive.devdayapp.grpc.HelloServiceOuterClass.HelloResponse> responseObserver) {
        HelloResponse.Builder builder = HelloResponse.newBuilder().setGreeting("No You");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}

