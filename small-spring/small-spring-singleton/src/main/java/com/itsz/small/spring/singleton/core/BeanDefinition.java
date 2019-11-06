package com.itsz.small.spring.singleton.core;

public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    String SCOPE_DEFAULT = "";


    /**
     * 获取bean全类名
     *
     * @return
     */
    String getBeanClassName();


    boolean isSingleton();


    boolean isPrototype();


    String getScope();


    void setScope(String scope);
}
