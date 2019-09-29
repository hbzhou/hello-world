package com.itsz.java.design.pattern.decorator;

public class DecoratorTester {

    public static void main(String[] args) {
        SMSOperator cmccOperator = new CMCCOperator(new CUCCOperator());
        cmccOperator.sendSMS();
    }
}
