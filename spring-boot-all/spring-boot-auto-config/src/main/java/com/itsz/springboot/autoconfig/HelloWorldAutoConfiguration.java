package com.itsz.springboot.autoconfig;

import com.itsz.springboot.autoconfig.annotation.EnableSayHello;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSayHello
@ConditionalOnProperty(name = "helloworld", havingValue = "true")
public class HelloWorldAutoConfiguration {
}
