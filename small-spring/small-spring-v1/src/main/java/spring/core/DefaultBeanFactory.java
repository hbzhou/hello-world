package spring.core;

import spring.exception.BeanCreationeException;
import spring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public Object getBean(String beanId) throws BeanCreationeException {
        BeanDefinition bd = beanDefinitionMap.get(beanId);
        if (bd == null) {
            throw new BeanCreationeException("bean definition not found");
        }
        String clazzName = bd.getBeanClassName();
        ClassLoader classLoader = ClassUtils.getClassLoader();
        try {
            Class<?> clazz = classLoader.loadClass(clazzName);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationeException("bean create failed");
        }

    }

    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanId, beanDefinition);
    }

}
