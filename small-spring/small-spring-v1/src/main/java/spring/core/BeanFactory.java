package spring.core;

import spring.exception.BeanCreationeException;

public interface BeanFactory {


    Object getBean(String beanId) throws BeanCreationeException;

}
