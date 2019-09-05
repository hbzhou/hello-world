package com.itsz.java.design.pattern.factory.simple;

import com.itsz.java.design.pattern.factory.EmailSender;
import com.itsz.java.design.pattern.factory.SMSSender;
import com.itsz.java.design.pattern.factory.Sender;

/**
 * 简单工厂模式
 * @author jeremy
 */
public class SimpleSenderFactory {
    public static final String EMAIL = "email";
    public static final String SMS = "sms";

    public static Sender produceSender(String type) {
        if (EMAIL.equals(type)) {
            return new EmailSender();
        } else if (SMS.equals(type)) {
            return new SMSSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
