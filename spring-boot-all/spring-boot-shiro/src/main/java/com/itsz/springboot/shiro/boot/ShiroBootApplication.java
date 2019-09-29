package com.itsz.springboot.shiro.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.itsz.springboot.shiro.boot",
                "com.itsz.springboot.shiro.user.controller",
                "com.itsz.springboot.shiro.user.service",
                "com.itsz.springboot.shiro.auth.controller"
        }
)
public class ShiroBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroBootApplication.class,args);
    }
}
