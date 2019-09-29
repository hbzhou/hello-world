package com.itsz.java.design.pattern.adapter.object;

public class Phone {

    public void charging(Voltage5V voltage5V) {
        int dst = voltage5V.output5V();
        System.out.println("phone is charging under " + dst + "V");
    }
}
