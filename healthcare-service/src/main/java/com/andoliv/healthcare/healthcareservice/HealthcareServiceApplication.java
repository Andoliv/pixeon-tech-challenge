package com.andoliv.healthcare.healthcareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HealthcareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareServiceApplication.class, args);
    }

}

