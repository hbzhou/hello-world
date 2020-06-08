package com.itsz.java.xml;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XmlParser {

    public static <T> T parse(InputStream inputStream, Class<T> entityClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(entityClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T obj = (T) unmarshaller.unmarshal(inputStream);
        return obj;
    }

    public static <T> T parse(Resource resource, Class<T> entityClass) {
        try {
            return parse(resource.getInputStream(), entityClass);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(String path, Class<T> entityClass) throws IOException, JAXBException {
        return parse(new ClassPathResource(path).getInputStream(), entityClass);
    }

    public static <T> Map<String, T> parseWithPattern(String pattern, Class<T> entityClass) throws IOException {
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader()).getResources(pattern);
        Map<String, T> map = Stream.of(resources).collect(Collectors.toMap(resource ->
                        FilenameUtils.getBaseName(resource.getFilename())
                , resource -> parse(resource, entityClass)));
        return map;
    }

    public static <T> List<T> parseReturnList(String pattern, Class<T> entityClass) throws IOException {
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader()).getResources(pattern);
        List<T> list = Stream.of(resources)
                .map(resource -> parse(resource, entityClass))
                .collect(Collectors.toList());
        return list;

    }


}
