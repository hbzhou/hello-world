package com.itsz.java.thread.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class MyDataPlus {

    volatile int number = 0;

    public void increment() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
