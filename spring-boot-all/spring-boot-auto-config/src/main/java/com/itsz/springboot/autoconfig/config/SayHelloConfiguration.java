package com.itsz.springboot.autoconfig.config;

import com.itsz.springboot.autoconfig.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SayHelloConfiguration {

    @Bean
    public HelloWorldService helloWorldService(){
        return new HelloWorldService();
    }
}
