package com.itsz.spring.cloud.eureka.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaBootApplication.class, args);
    }
}
