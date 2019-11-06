package com.itsz.small.spring.singleton.test;

import com.itsz.small.spring.singleton.core.*;
import com.itsz.small.spring.singleton.exception.BeanCreationeException;
import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingletonBeanDefinition() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        Resource resource = new ClassPathResource("bean-singleton.xml");
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinition(resource);
        BeanDefinition beanDefinition = factory.getBeanDefinition("helloWorldService");
        Assert.assertTrue(beanDefinition.isSingleton());
        Assert.assertFalse(beanDefinition.isPrototype());
    }

    @Test
    public void testGetSingleton() throws BeanCreationeException {
        ApplicationContext applicationContext = new XmlClassPathApplicationContext("bean-singleton.xml");
        Object object = applicationContext.getBean("helloWorldService");
        Assert.assertNotNull(object);
        Object object2 = applicationContext.getBean("helloWorldService");
        Assert.assertEquals(object, object2);
    }

    @Test
    public void testGetPrototype() throws BeanCreationeException {
        ApplicationContext applicationContext = new XmlClassPathApplicationContext("bean-singleton.xml");
        Object object = applicationContext.getBean("helloWorldPrototypeService");
        Assert.assertNotNull(object);
        Object object2 = applicationContext.getBean("helloWorldPrototypeService");
        Assert.assertNotEquals(object, object2);
    }
}
