package com.itsz.java.dynamic.proxy;

import java.lang.reflect.Proxy;

import com.itsz.java.dynamic.proxy.proxy.JDKProxy;
import com.itsz.java.dynamic.proxy.service.HelloWorldService;
import com.itsz.java.dynamic.proxy.service.impl.HelloWorldServiceImpl;

/**
 * @author jeremy
 */
public class JDKProxyTester {

    public static void main(String[] args) {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        long time = System.currentTimeMillis();
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{HelloWorldService.class}, new JDKProxy(helloWorldService));
        time = System.currentTimeMillis() - time;
        System.out.println("Create JDK Proxy: " + time + " ms");
        helloWorldServiceProxy.sayHello("jdk1.8 proxy");

    }
}
