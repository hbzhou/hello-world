package com.itsz.spring.cloud.feign.consumer.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.itsz.spring.cloud.feign.consumer.boot",
        "com.itsz.spring.cloud.feign.consumer.controller",
        "com.itsz.spring.cloud.feign.consumer.feign"

})
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients(basePackages = {
        "com.itsz.spring.cloud.feign.consumer.feign"
}
)
public class FeignConsumerBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerBootApplication.class, args);
    }
}
