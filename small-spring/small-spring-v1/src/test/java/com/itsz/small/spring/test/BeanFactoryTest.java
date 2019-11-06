package com.itsz.small.spring.test;

import org.junit.Assert;
import org.junit.Test;
import spring.bean.HelloWorldService;
import spring.core.DefaultBeanFactory;
import spring.core.XmlBeanDefinitionReader;
import spring.exception.BeanCreationeException;

public class BeanFactoryTest {

    @Test
    public void testGetBean() throws BeanCreationeException {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefition("bean-v1.xml");
        Object obj = factory.getBean("helloWorldService");
        Assert.assertNotNull(obj);
        HelloWorldService helloWorldService = ((HelloWorldService) obj);
        Assert.assertEquals("Hello", helloWorldService.sayHello());
    }



}
