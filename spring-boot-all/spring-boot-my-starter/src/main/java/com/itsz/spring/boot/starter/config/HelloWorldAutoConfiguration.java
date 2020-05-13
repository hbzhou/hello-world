package com.itsz.spring.boot.starter.config;

import com.itsz.spring.boot.starter.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloWorldProperties.class)
@ConditionalOnClass(HelloWorldService.class)
public class HelloWorldAutoConfiguration {

    @Autowired
    private HelloWorldProperties helloWorldProperties;


    @Bean
    HelloWorldService helloWorldService() {
        return new HelloWorldService(helloWorldProperties.getName(), helloWorldProperties.getMessage());
    }
}
