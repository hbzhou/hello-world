package com.itsz.java.design.pattern.bridge;

public class BridgeTester {

    public static void main(String[] args) {
        SMSSender smsSender = new AsynSMSSender(new XGATEOperator());
        smsSender.sendSMS();
    }
}
