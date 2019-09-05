package com.itsz.java.dynamic.proxy;

import com.itsz.java.dynamic.proxy.proxy.CglibProxy;
import com.itsz.java.dynamic.proxy.service.HelloWorldService;
import com.itsz.java.dynamic.proxy.service.impl.HelloWorldServiceImpl;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTester {

    public static void main(String[] args) {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();

        long time = System.currentTimeMillis();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibProxy(helloWorldService));
        enhancer.setInterfaces(new Class[]{HelloWorldService.class});
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) enhancer.create();
        time = System.currentTimeMillis() - time;
        System.out.println("Create CGLIB Proxy: " + time + " ms");

        System.out.println(helloWorldServiceProxy.sayHello("cglib proxy"));

    }
}
