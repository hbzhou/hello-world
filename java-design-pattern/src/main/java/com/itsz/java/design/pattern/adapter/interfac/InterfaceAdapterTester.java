package com.itsz.java.design.pattern.adapter.interfac;

public class InterfaceAdapterTester {

    public static void main(String[] args) {
        InterfaceAdapter adapter = new InterfaceAdapter() {
            @Override
            public void m1() {
                System.out.println("implement m1 .....");
            }
        };

        adapter.m1();
    }
}
