package com.example.springserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringServiceProviderApplication.class, args);
    }

}
