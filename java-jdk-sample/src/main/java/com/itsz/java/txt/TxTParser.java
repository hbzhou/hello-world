package com.itsz.java.txt;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxTParser {
    public static final String REG_NUMERIC_PREFIX_LINE = "^[0-9]+.*$";
    public static final String REG_TABLE_HEADER = "^#.*";


    public static <T> List<T> parse(Resource resource, Class<T> entityClass) {
        try {
            Stream<String> lines = new BufferedReader(new InputStreamReader(resource.getInputStream())).lines();
            return lines.filter(line -> line.matches(REG_NUMERIC_PREFIX_LINE))
                    .filter(line -> line.matches(REG_TABLE_HEADER))
                    .distinct()
                    .map(line -> createEntity(line, entityClass))
                    .filter(Objects::isNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T createEntity(String line, Class<T> entityClass) {
        try {
            String[] split = line.split(";");
            T instance = entityClass.newInstance();
            //TODO  reflection or BeanUtils to set attribute
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> parsePattern(String pattern, Class<T> entityClass) throws IOException {
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader()).getResources(pattern);
        return Stream.of(resources).map(resource -> parse(resource, entityClass))
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
    }


}
