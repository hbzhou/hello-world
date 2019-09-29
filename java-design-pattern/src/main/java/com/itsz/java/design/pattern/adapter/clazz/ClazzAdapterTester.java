package com.itsz.java.design.pattern.adapter.clazz;

/**
 *
 * 类适配器
 * @author jeremy
 */
public class ClazzAdapterTester {

    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.charging( new VoltageAdapter());
    }
}
