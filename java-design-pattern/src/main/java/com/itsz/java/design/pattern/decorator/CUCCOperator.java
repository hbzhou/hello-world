package com.itsz.java.design.pattern.decorator;

public class CUCCOperator implements SMSOperator {

    private SMSOperator smsOperator;

    public CUCCOperator(SMSOperator smsOperator) {
        this.smsOperator = smsOperator;
    }

    public CUCCOperator() {
    }

    @Override
    public void sendSMS() {
        try {
            System.out.println("CUCC 发送短信");
            new RuntimeException();
        } catch (Exception e) {
            if(smsOperator!=null){
                System.out.println("另外一运营商发短信。。");
                smsOperator.sendSMS();
            }
        }

    }
}
