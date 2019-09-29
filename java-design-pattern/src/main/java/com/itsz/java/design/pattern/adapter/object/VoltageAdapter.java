package com.itsz.java.design.pattern.adapter.object;

public class VoltageAdapter  implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int output = voltage220V.output220();
        System.out.println("适配器转换中");
        int dest = output/44;
        return dest;
    }
}
