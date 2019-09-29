package com.itsz.java.design.pattern.singleton;

public enum EnumSingleton {

    INSTANCE;

    public String sayHello (){
        return "Hello singleton";
    }
}
