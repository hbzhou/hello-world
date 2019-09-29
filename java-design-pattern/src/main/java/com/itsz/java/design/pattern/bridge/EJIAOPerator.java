package com.itsz.java.design.pattern.bridge;

public class EJIAOPerator implements SMSOperator {


    @Override
    public void sendSMS() {
        System.out.println("用EJIA发短信");
    }
}
