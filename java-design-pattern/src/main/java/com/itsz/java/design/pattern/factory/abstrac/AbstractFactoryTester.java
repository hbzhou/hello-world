package com.itsz.java.design.pattern.factory.abstrac;

import com.itsz.java.design.pattern.factory.Sender;

public class AbstractFactoryTester {

    public static void main(String[] args) {
        SenderFactory factory = new SMSSenderFactory();
        Sender smsSender = factory.produce();
        smsSender.send();

        SenderFactory  senderFactory = new EmailSenderFactory();
        Sender emailSender = senderFactory.produce();
        emailSender.send();

    }
}
