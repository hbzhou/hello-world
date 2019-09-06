package com.itsz.java.nio.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileService {

    void writeLines(Path fileSubPath, String encoding, Iterable<String> lines, boolean append) throws IOException;

    void appendLines(Path fileSubPath, String encoding, Iterable<String> lines) throws IOException;

    void writeLines(Path fileSubPath, String encoding, Iterable<String> lines) throws IOException;

    void appendLines(Path fileSubPath, Iterable<String> lines) throws IOException;

    void writeLines(Path fileSubPath, Iterable<String> lines, boolean append) throws IOException;

    void writeLines(Path fileSubPath, Iterable<String> lines) throws IOException;

    void writeByteArrayToFile(Path fileSubPath, byte[] data, boolean append) throws IOException;

    void appendByteArrayToFile(Path fileSubPath, byte[] data) throws IOException;

    void writeByteArrayToFile(Path fileSubPath, byte[] data) throws IOException;

    List<String> readLines(Path fileSubPath, String encoding) throws IOException;

    List<String> readLines(Path fileSubPath) throws IOException;

    byte[] readFileToByteArray(Path fileSubPath) throws IOException;

    Path appendDirectoryPath(Path dirSubPath);

    Path appendAndCreateDirectoryPath(Path dirSubPath) throws IOException;

    Path appendFilePath(Path fileSubPath) throws IOException;

    Path getBasePath();
}
