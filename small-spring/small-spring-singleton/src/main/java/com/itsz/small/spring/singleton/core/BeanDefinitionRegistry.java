package com.itsz.small.spring.singleton.core;


public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);


    BeanDefinition getBeanDefinition (String beanId);
}
