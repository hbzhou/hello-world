package com.itsz.java.thread.concurrent;

public class Singleton {

    private static volatile Singleton singleton = null;

    private static Object lock = new Object();


    private Singleton() {
        System.out.println(Thread.currentThread().getName() + " init");
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (lock) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
