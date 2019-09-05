package com.itsz.java.design.pattern.singleton;

/**
 * 懒汉式单列是线程不安全的
 *
 * @author jeremy
 */
public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

}
