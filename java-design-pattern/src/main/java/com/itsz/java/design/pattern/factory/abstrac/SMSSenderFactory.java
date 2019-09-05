package com.itsz.java.design.pattern.factory.abstrac;

import com.itsz.java.design.pattern.factory.SMSSender;
import com.itsz.java.design.pattern.factory.Sender;

public class SMSSenderFactory implements SenderFactory {

    @Override
    public Sender produce() {
        return new SMSSender();
    }
}
