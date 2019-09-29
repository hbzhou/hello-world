package com.itsz.springboot.sms.security.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "com.itsz.springboot.sms.security.boot",
                "com.itsz.springboot.sms.security.auth.controller",
                "com.itsz.springboot.sms.security.user.service"
        }
)
public class SecuritySMSBootApplication   {



    public static void main(String[] args) {
        SpringApplication.run(SecuritySMSBootApplication.class, args);
    }


}
