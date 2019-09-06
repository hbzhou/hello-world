package com.itsz.java.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelTester {

    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = FileChannel.open(Paths.get("D:\\Jeremy\\spring\\hello-world\\java-jdk-sample\\src\\main\\resources\\image\\hk_idCard.jpg"));
        FileChannel fileChannelWrite = FileChannel.open(Paths.get("D:\\Jeremy\\spring\\hello-world\\java-jdk-sample\\src\\main\\resources\\image\\hk_idCard_backup.jpg"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            fileChannelWrite.write(buffer);
            buffer.clear();
        }

        fileChannel.close();
        fileChannelWrite.close();


    }
}
