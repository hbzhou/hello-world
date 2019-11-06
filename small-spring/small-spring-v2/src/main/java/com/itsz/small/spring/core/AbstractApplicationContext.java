package com.itsz.small.spring.core;

import com.itsz.small.spring.exception.BeanCreationeException;

public abstract class AbstractApplicationContext implements ApplicationContext {

    protected DefaultBeanFactory factory;

    public AbstractApplicationContext(String filePath) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(getResourceByPath(filePath));
    }

    public abstract Resource getResourceByPath(String filePath);


    @Override
    public Object getBean(String beanId) throws BeanCreationeException {
        return factory.getBean(beanId);
    }
}
