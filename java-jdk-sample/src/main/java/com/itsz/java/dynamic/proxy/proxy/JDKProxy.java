package com.itsz.java.dynamic.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {

    final Object delegate;

    public JDKProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(delegate, args);
    }

}
