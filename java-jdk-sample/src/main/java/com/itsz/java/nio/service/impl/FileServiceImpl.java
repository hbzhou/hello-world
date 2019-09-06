package com.itsz.java.nio.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itsz.java.nio.service.FileService;

public class FileServiceImpl implements FileService {
    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    private Path basePath;

    public FileServiceImpl(String basePath) throws IOException {
        this(basePath, true);
    }

    public FileServiceImpl(String basePath, boolean createPathIfNotExist) throws IOException {
        this.basePath = Paths.get(basePath);
        if (createPathIfNotExist && Files.notExists(this.basePath, new LinkOption[0])) {
            try {
                Files.createDirectories(this.basePath);
            } catch (IOException var4) {
                LOG.error("log=\"Fail to create directory\", dir={}", this.basePath.toAbsolutePath().toString());
                throw var4;
            }
        }

    }

    private void isNotAbsolutePath(Path path) {
        if (path.isAbsolute()) {
            throw new IllegalArgumentException("Path " + path + " must be an absolute path!");
        }
    }

    @Override
    public Path appendDirectoryPath(Path dirSubPath) {
        this.isNotAbsolutePath(dirSubPath);
        return this.basePath.resolve(dirSubPath);
    }

    @Override
    public Path appendAndCreateDirectoryPath(Path dirSubPath) throws IOException {
        this.isNotAbsolutePath(dirSubPath);
        Path fullPath = this.basePath.resolve(dirSubPath);
        if (Files.notExists(fullPath, new LinkOption[0])) {
            Files.createDirectories(fullPath);
        }

        return fullPath;
    }

    @Override
    public Path appendFilePath(Path fileSubPath) throws IOException {
        this.isNotAbsolutePath(fileSubPath);
        Path fullPath = this.basePath.resolve(fileSubPath);
        Path parent = fullPath.getParent();
        if (parent == null) {
            throw new InvalidPathException(fullPath.toString(), "No parent path");
        } else {
            if (Files.notExists(parent, new LinkOption[0])) {
                Files.createDirectories(parent);
            }

            return fullPath;
        }
    }

    @Override
    public Path getBasePath() {
        return this.basePath;
    }


    @Override
    public byte[] readFileToByteArray(Path fileSubPath) throws IOException {
        return Files.readAllBytes(this.appendFilePath(fileSubPath));
    }

    @Override
    public List<String> readLines(Path fileSubPath) throws IOException {
        return Files.readAllLines(this.appendFilePath(fileSubPath), Charset.defaultCharset());
    }

    @Override
    public List<String> readLines(Path fileSubPath, String encoding) throws IOException {
        return Files.readAllLines(this.appendFilePath(fileSubPath), Charset.forName(encoding));
    }

    @Override
    public void writeByteArrayToFile(Path fileSubPath, byte[] data) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), data, new OpenOption[0]);
    }

    @Override
    public void writeByteArrayToFile(Path fileSubPath, byte[] data, boolean append) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), data, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING});
    }

    @Override
    public void appendByteArrayToFile(Path fileSubPath, byte[] data) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), data, new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE});
    }

    @Override
    public void writeLines(Path fileSubPath, Iterable<String> lines) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.defaultCharset());
    }

    @Override
    public void appendLines(Path fileSubPath, Iterable<String> lines) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
    }

    @Override
    public void writeLines(Path fileSubPath, Iterable<String> lines, boolean append) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Override
    public void writeLines(Path fileSubPath, String encoding, Iterable<String> lines) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.forName(encoding));
    }

    @Override
    public void appendLines(Path fileSubPath, String encoding, Iterable<String> lines) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.forName(encoding), StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
    }

    @Override
    public void writeLines(Path fileSubPath, String encoding, Iterable<String> lines, boolean append) throws IOException {
        Files.write(this.appendFilePath(fileSubPath), lines, Charset.forName(encoding), StandardOpenOption.CREATE, StandardOpenOption.WRITE, append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
    }
}
