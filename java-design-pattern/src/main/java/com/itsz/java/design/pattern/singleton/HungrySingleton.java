package com.itsz.java.design.pattern.singleton;

/**
 * 饿汉式单例
 * 1.优点：没有加任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好。
 * 2.缺点：类加载的时候就初始化，不管用与不用都占着空间，浪费了内存，有可能占着
 *
 *
 * @author jeremy
 */
public class HungrySingleton {

    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
