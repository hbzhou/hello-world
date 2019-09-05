package com.itsz.java.design.pattern.factory.simple;

import com.itsz.java.design.pattern.factory.Sender;

public class SimpleSenderFactoryTester {

    public static void main(String[] args) {
        Sender sender = SimpleSenderFactory.produceSender(SimpleSenderFactory.EMAIL);
        sender.send();
    }
}
