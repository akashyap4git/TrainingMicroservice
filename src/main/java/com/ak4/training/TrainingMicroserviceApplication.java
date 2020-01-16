package com.ak4.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TrainingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingMicroserviceApplication.class, args);
	}

}
