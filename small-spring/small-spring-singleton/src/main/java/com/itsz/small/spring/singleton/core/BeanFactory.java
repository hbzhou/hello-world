package com.itsz.small.spring.singleton.core;

import com.itsz.small.spring.singleton.exception.BeanCreationeException;

public interface BeanFactory {


    Object getBean(String beanId) throws BeanCreationeException;

}
