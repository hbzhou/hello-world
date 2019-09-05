package com.itsz.java.design.pattern.factory.abstrac;

import com.itsz.java.design.pattern.factory.EmailSender;
import com.itsz.java.design.pattern.factory.Sender;

public class EmailSenderFactory implements SenderFactory {

    @Override
    public Sender produce() {
        return new EmailSender();
    }
}
