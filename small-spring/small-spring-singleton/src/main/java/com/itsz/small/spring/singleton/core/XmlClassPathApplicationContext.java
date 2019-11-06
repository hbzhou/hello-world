package com.itsz.small.spring.singleton.core;


public class XmlClassPathApplicationContext extends AbstractApplicationContext {


    public XmlClassPathApplicationContext(String filePath) {
        super(filePath);

    }

    @Override
    protected Resource getResourceByPath(String filePath) {
        return new ClassPathResource(filePath);
    }

}