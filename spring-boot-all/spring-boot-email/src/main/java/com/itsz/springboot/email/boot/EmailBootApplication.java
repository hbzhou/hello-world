package com.itsz.springboot.email.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.itsz.springboot.email.boot",
                "com.itsz.springboot.email.controller"
        }
)
public class EmailBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailBootApplication.class,args);
    }
}
