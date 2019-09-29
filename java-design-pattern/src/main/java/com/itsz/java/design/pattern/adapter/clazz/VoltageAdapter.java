package com.itsz.java.design.pattern.adapter.clazz;

public class VoltageAdapter extends Voltage220V implements Voltage5V {


    @Override
    public int output5V() {
        int output = output220();
        System.out.println("适配器转换中");
        int dest = output/44;
        return dest;
    }
}
