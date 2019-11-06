package spring.core;


public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanId);


    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);
}
