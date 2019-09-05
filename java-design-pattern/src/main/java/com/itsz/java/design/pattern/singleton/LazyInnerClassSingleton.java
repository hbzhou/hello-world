package com.itsz.java.design.pattern.singleton;

/**
 *  饿汉式单例
 * 1.延迟加载(使用的时候才会实例化),避免项目启动内存的消耗
 * 2.内部类一定是在方法调用之前初始化，巧妙地避免了线程安全问题
 * @author jeremy
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton (){}

    public static LazyInnerClassSingleton getInstance(){
        return LazySingletonHolder.singleton;
    }

    private static class LazySingletonHolder {

        private static final LazyInnerClassSingleton singleton = new LazyInnerClassSingleton();
    }
}
