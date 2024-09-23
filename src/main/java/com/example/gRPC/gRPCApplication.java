package com.example.gRPC;

import com.example.gRPC.Service.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class gRPCApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(gRPCApplication.class, args);
		Server server = ServerBuilder.forPort(9090)
				.addService(new UserServiceImpl())
				.build()
				.start();
		server.awaitTermination();
	}

}
