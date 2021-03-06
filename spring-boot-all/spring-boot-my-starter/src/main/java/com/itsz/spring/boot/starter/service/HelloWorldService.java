package com.itsz.spring.boot.starter.service;


public class HelloWorldService {

    private String name;

    private String message;

    public HelloWorldService(String name, String message) {
        this.name = name;
        this.message = message;
    }

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

    public String sayHelloWorld(){
        return this.name + " SAYS " + this.message;
    }
}
