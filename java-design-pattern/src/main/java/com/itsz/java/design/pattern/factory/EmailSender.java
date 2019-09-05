package com.itsz.java.design.pattern.factory;

import com.itsz.java.design.pattern.factory.Sender;

public class EmailSender implements Sender {


    @Override
    public void send() {
        System.out.println("sending email....");
    }
}
