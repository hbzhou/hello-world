package com.itsz.java.dynamic.proxy.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

    final Object delegate;

    public CglibProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return method.invoke(delegate,objects) ;
    }
}
