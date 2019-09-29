package com.itsz.springboot.mybatis.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.itsz.springboot.mybatis.boot",
        "com.itsz.springboot.mybatis.user.controller",
        "com.itsz.springboot.mybatis.user.service"

})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);

    }

}
