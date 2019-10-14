package com.itsz.spring.cloud.feign.provider.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello" + name + "from port:" + port;
    }
}
