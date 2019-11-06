package com.itsz.small.spring.singleton.core;

public class FileSystemApplicationContext extends AbstractApplicationContext {


    public FileSystemApplicationContext(String filePath) {
        super(filePath);
    }

    @Override
    protected Resource getResourceByPath(String filePath) {
        return new FileSystemResource(filePath);
    }
}
