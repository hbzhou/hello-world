package com.itsz.java.design.pattern.factory.complex;

import com.itsz.java.design.pattern.factory.EmailSender;
import com.itsz.java.design.pattern.factory.SMSSender;
import com.itsz.java.design.pattern.factory.Sender;

/**
 * 复杂工厂模式
 * @author jeremy
 */
public class ComplexSenderFactory {

    public static Sender produceSMSSender() {
        return new SMSSender();
    }

    public static Sender produceEmailSender() {
        return new EmailSender();
    }
}
