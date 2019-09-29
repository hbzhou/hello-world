package com.itsz.java.design.pattern.adapter.object;

/**
 *
 * 类适配器
 * @author jeremy
 */
public class ObjectAdapterTester {

    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.charging( new VoltageAdapter(new Voltage220V()));
    }
}
