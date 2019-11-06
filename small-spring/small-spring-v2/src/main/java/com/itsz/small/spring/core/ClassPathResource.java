package com.itsz.small.spring.core;

import com.itsz.small.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private String filePath;

    public ClassPathResource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream in = null;
        try {
            in = ClassUtils.getClassLoader().getResourceAsStream(filePath);
        } catch (Exception e) {
            throw new FileNotFoundException("file not found");
        }
        return in;

    }
}
