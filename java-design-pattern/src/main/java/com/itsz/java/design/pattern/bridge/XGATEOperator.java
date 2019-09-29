package com.itsz.java.design.pattern.bridge;

public class XGATEOperator implements SMSOperator {
    @Override
    public void sendSMS() {
        System.out.println("XGATE sending SMS");
    }
}
