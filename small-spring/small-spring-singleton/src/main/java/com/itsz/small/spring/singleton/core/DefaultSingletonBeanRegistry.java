package com.itsz.small.spring.singleton.core;

import org.junit.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonRegistryMap = new ConcurrentHashMap<>();


    @Override
    public void registerSingleton(String beanName, Object singleton) {
        Object object = singletonRegistryMap.get(beanName);
        if (object != null) {
            throw new IllegalStateException("Could not register object [" + singleton +
                    "] under bean name '" + beanName + "': there is already object [" + object + "] bound");
        }
        singletonRegistryMap.put(beanName, singleton);

    }

    @Override
    public Object getSingleton(String beanId) {
        return singletonRegistryMap.get(beanId);
    }
}
