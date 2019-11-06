package com.itsz.small.spring.core;


public class XmlClassPathApplicationContext extends AbstractApplicationContext {


    public XmlClassPathApplicationContext(String filePath) {
        super(filePath);

    }

    @Override
    public Resource getResourceByPath(String filePath) {
        return new ClassPathResource(filePath);
    }

}