package com.itsz.small.spring.singleton.core;


import com.itsz.small.spring.singleton.exception.BeanCreationeException;
import com.itsz.small.spring.singleton.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public Object getBean(String beanId) throws BeanCreationeException {
        BeanDefinition bd = getBeanDefinition(beanId);
        if (bd == null) {
            throw new BeanCreationeException("bean definition not found");
        }
        if (bd.isSingleton()) {
            Object obj = getSingleton(beanId);
            if (obj == null) {
                obj = createBean(bd);
                registerSingleton(beanId, obj);
            }
            return obj;
        }
        return createBean(bd);

    }

    private Object createBean(BeanDefinition bd) throws BeanCreationeException {
        String clazzName = bd.getBeanClassName();
        ClassLoader classLoader = ClassUtils.getClassLoader();
        try {
            Class<?> clazz = classLoader.loadClass(clazzName);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationeException("bean create failed");
        }
    }

    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanId, beanDefinition);
    }

}
