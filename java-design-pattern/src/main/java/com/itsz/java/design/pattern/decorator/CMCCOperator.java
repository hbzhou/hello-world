package com.itsz.java.design.pattern.decorator;


/**
 * 中国移动
 */
public class CMCCOperator implements SMSOperator {

    private SMSOperator smsOperator;

    public CMCCOperator(SMSOperator smsOperator) {
        this.smsOperator = smsOperator;
    }

    public CMCCOperator() {
    }

    @Override
    public void sendSMS() {
        try {
            System.out.println("CMCC 发送短信");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("发送失败");
            if (smsOperator != null) {
                System.out.println("另外一运营商发短信。。");
                smsOperator.sendSMS();
            }
        }

    }
}
