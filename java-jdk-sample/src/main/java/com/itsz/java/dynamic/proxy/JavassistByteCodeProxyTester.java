package com.itsz.java.dynamic.proxy;

import com.itsz.java.dynamic.proxy.service.HelloWorldService;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

public class JavassistByteCodeProxyTester {

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        ClassPool mPool = new ClassPool(true);
        CtClass mCtc = mPool.makeClass(HelloWorldService.class.getName() + "JavaassistProxy");
        mCtc.addInterface(mPool.get(HelloWorldService.class.getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        mCtc.addMethod(CtNewMethod.make("public String sayHello(String name) {\n" +" return \"HellWorld, \" + name;\n" + " }", mCtc));
        Class<?> pc = mCtc.toClass();
        HelloWorldService byteCodeProxy = (HelloWorldService) pc.newInstance();
        time = System.currentTimeMillis() - time;
        System.out.println("Create JavassistBytecode Proxy: " + time + " ms");
        System.out.println(byteCodeProxy.sayHello("javassist bytecode"));

    }
}
