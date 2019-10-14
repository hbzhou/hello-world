package com.itsz.spring.cloud.zuul.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulBootApplication.class,args);
    }
}
