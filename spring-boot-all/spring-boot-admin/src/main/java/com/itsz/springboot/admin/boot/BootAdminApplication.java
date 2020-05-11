package com.itsz.springboot.admin.boot;

import com.itsz.spring.boot.starter.service.HelloWorldService;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class BootAdminApplication implements CommandLineRunner {

    @Autowired
    HelloWorldService helloWorldService;

    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class,args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloWorldService.sayHelloWorld());
    }
}
