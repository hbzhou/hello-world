package com.itsz.small.spring.singleton.core;

public interface SingletonBeanRegistry {

    void registerSingleton(String beanId, Object singleton);


    Object getSingleton(String beanId);
}
