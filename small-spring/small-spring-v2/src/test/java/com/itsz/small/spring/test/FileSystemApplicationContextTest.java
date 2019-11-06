package com.itsz.small.spring.test;

import com.itsz.small.spring.bean.HelloWorldService;
import com.itsz.small.spring.core.FileSystemApplicationContext;
import com.itsz.small.spring.exception.BeanCreationeException;
import org.junit.Assert;
import org.junit.Test;

public class FileSystemApplicationContextTest {

    @Test
    public void testGetBean() throws BeanCreationeException {
        FileSystemApplicationContext applicationContext = new FileSystemApplicationContext("D:\\Jeremy\\spring\\hello-world\\small-spring\\small-spring-v2\\src\\test\\resources\\bean-v2.xml");
        Object bean = applicationContext.getBean("helloWorldService");
        Assert.assertNotNull(bean);
        HelloWorldService helloWorldService = ((HelloWorldService) bean);
        Assert.assertEquals("Hello", helloWorldService.sayHello());

    }
}
