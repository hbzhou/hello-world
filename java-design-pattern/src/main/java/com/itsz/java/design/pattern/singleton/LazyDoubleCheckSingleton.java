package com.itsz.java.design.pattern.singleton;

/**
 *
 * 懒汉双重加锁校验
 *用了synchronized 加锁,所以性能会有所消耗
 *
 * @author jeremy
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton singleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
