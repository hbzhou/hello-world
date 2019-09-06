package com.itsz.java.nio;

import java.io.IOException;
import java.nio.file.Paths;

import com.itsz.java.nio.service.FileService;
import com.itsz.java.nio.service.impl.FileServiceImpl;

public class FileServiceTester {

    public static void main(String[] args) throws IOException {
        FileService fileService = new FileServiceImpl("D:\\Jeremy\\spring\\hello-world\\java-jdk-sample\\src\\main\\resources");
        byte[] bytes = fileService.readFileToByteArray(Paths.get("image","hk_idCard.jpg"));
        fileService.writeByteArrayToFile(Paths.get("image", "hk_idcard_1.jpg"), bytes);
    }
}
