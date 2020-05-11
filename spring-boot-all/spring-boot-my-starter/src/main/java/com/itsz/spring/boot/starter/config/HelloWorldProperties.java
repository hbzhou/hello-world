package com.itsz.spring.boot.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.itsz")
public class HelloWorldProperties {

    private static final String DEFAULT_NAME = "JEREMY GILBERT";
    private static final String DEFAULT_MESSAGE = "HELLO, WORLD";

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
