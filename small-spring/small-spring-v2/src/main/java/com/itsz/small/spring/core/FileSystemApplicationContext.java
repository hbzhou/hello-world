package com.itsz.small.spring.core;

import com.itsz.small.spring.exception.BeanCreationeException;


public class FileSystemApplicationContext extends AbstractApplicationContext {


    public FileSystemApplicationContext(String filePath) {
        super(filePath);
    }

    @Override
    public Resource getResourceByPath(String filePath) {
        return new FileSystemResource(filePath);
    }
}
