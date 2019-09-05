package com.itsz.java.dynamic.proxy.service.impl;

import com.itsz.java.dynamic.proxy.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "HellWorld, " + name;
    }
}
