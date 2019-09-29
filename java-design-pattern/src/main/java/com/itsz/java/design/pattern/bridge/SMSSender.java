package com.itsz.java.design.pattern.bridge;

public abstract class SMSSender {

    private SMSOperator smsOperator;


    public SMSSender(SMSOperator smsOperator) {
        this.smsOperator = smsOperator;
    }

    public void sendSMS(){
        smsOperator.sendSMS();
    }
}
