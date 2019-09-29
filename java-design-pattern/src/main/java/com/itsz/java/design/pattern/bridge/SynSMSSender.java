package com.itsz.java.design.pattern.bridge;

import java.sql.SQLOutput;

public class SynSMSSender extends SMSSender{
    public SynSMSSender(SMSOperator smsOperator) {
        super(smsOperator);
    }

    @Override
    public void sendSMS() {
        System.out.println("开始同步发短信");
        super.sendSMS();
    }
}
