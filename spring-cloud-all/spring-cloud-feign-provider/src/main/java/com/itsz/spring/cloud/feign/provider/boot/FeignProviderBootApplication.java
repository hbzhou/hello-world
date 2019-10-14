package com.itsz.spring.cloud.feign.provider.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class FeignProviderBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignProviderBootApplication.class, args);
    }
}
