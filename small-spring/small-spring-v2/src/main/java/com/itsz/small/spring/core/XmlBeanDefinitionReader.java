package com.itsz.small.spring.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {
    private static final String ID_ATTR = "id";
    private static final String CLASS_ATTR = "class";

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinition(Resource resource) {
        try {
            InputStream in = resource.getInputStream();
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue(ID_ATTR);
                String clazzName = element.attributeValue(CLASS_ATTR);
                BeanDefinition beanDefinition = new GenericBeanDefinition(id, clazzName);
                beanDefinitionRegistry.registerBeanDefinition(id, beanDefinition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
