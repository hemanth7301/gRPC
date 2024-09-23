package com.example.gRPC.Service;

import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private static int userId = 1;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        String name = request.getName();
        int age = request.getAge();
        UserResponse response = UserResponse.newBuilder()
                .setUserId(userId++)
                .setName("Hi " + name)
                .setAge("Your age is " + age)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
