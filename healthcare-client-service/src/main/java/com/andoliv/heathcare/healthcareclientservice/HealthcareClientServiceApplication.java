package com.andoliv.heathcare.healthcareclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HealthcareClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareClientServiceApplication.class, args);
	}

}
