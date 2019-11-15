package com.itsz.java.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesMainTest {

    @Test
    public void testListFiles () throws IOException {
        Files.list(Paths.get("D:\\Jeremy\\h5-production\\帮助中心生产9-29\\dist\\static")).filter(Files::isRegularFile).forEach(System.out:: println);
    }


    @Test
    public void testListFilsWithNewDir() throws IOException {
        Files.newDirectoryStream(Paths.get("D:\\Jeremy\\h5-production\\帮助中心生产9-29\\dist\\static"), path-> path.toFile().isFile()).forEach(System.out::println);
    }


    @Test
    public void testListFilesOfPostFix () throws IOException {
        Files.newDirectoryStream(Paths.get("D:\\Jeremy\\h5-production\\帮助中心生产9-29\\dist\\static"), path -> path.toString().endsWith(".java")).forEach(System.out::println);
    }
}
