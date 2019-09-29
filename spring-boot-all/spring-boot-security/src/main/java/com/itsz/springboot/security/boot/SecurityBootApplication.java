package com.itsz.springboot.security.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication(
        scanBasePackages = {
                "com.itsz.springboot.security.boot",
                "com.itsz.springboot.security.auth.controller",
                "com.itsz.springboot.security.auth.filter",
                "com.itsz.springboot.security.user.service"
        }
)
public class SecurityBootApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(SecurityBootApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(UUID.randomUUID().toString());

    }
}
