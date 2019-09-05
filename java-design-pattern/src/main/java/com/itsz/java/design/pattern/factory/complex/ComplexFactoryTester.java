package com.itsz.java.design.pattern.factory.complex;


import com.itsz.java.design.pattern.factory.Sender;

public class ComplexFactoryTester {

    public static void main(String[] args) {
       Sender sender =  ComplexSenderFactory.produceSMSSender();
       sender.send();
    }
}
