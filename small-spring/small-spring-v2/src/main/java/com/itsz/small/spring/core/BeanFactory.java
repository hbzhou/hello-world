package com.itsz.small.spring.core;

import com.itsz.small.spring.exception.BeanCreationeException;

public interface BeanFactory {


    Object getBean(String beanId) throws BeanCreationeException;

}
