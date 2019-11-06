package com.itsz.small.spring.singleton.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {

    private String filePath;

    public FileSystemResource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }
}
