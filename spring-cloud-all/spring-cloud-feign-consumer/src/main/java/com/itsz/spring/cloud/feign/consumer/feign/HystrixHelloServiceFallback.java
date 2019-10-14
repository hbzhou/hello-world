package com.itsz.spring.cloud.feign.consumer.feign;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixHelloServiceFallback implements HelloFeignService {


    @Override
    public String hello(String name) {
        return "hello " + name + " from hystrix";
    }
}
