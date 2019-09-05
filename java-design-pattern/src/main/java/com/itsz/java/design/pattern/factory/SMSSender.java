package com.itsz.java.design.pattern.factory;


public class SMSSender implements Sender {

    @Override
    public void send() {
        System.out.println("sending SMS ...");
    }
}
