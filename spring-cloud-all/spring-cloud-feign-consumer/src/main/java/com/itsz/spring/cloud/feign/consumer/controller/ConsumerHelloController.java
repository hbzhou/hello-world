package com.itsz.spring.cloud.feign.consumer.controller;

import com.itsz.spring.cloud.feign.consumer.feign.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerHelloController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloFeignService.hello(name);
    }
}
