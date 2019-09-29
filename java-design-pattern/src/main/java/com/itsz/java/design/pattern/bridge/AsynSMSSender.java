package com.itsz.java.design.pattern.bridge;

public class AsynSMSSender extends SMSSender {
    public AsynSMSSender(SMSOperator smsOperator) {
        super(smsOperator);
    }

    @Override
    public void sendSMS() {
        System.out.println("开始异步发短信。。。。");
        super.sendSMS();
    }
}
