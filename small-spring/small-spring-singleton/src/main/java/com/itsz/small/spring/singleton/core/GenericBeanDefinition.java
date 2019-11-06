package com.itsz.small.spring.singleton.core;

public class GenericBeanDefinition implements BeanDefinition {

    private String id;

    private String className;

    private String scope;

    private boolean singleton = true;

    private boolean prototype = false;

    public GenericBeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public String getBeanClassName() {
        return this.className;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public boolean isPrototype() {
        return prototype;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_DEFAULT.equals(scope) || SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }
}
