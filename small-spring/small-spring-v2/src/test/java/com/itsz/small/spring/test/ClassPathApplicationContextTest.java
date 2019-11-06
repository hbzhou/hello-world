package com.itsz.small.spring.test;

import com.itsz.small.spring.bean.HelloWorldService;
import com.itsz.small.spring.core.XmlClassPathApplicationContext;
import com.itsz.small.spring.exception.BeanCreationeException;
import org.junit.Assert;
import org.junit.Test;

public class ClassPathApplicationContextTest {

    @Test
    public void testGetBean() throws BeanCreationeException {
        XmlClassPathApplicationContext applicationContext = new XmlClassPathApplicationContext("bean-v2.xml");
        Object obj = applicationContext.getBean("helloWorldService");
        Assert.assertNotNull(obj);
        HelloWorldService helloWorldService = ((HelloWorldService) obj);
        Assert.assertEquals("Hello", helloWorldService.sayHello());
    }
}
