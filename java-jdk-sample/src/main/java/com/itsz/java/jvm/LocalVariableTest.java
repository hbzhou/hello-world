package com.itsz.java.jvm;

import java.util.Date;

public class LocalVariableTest {

    public static void main(String[] args) {
        int i = 10;
        LocalVariableTest localVariableTest = new LocalVariableTest();
        localVariableTest.method1();
        System.out.println(i);
    }

    public void method1() {

        String str = "1231231";
        System.out.println(str);

        method2();
    }

    public void method2() {
        Date date1 = new Date();
        double number = 1.0;
        long l = 12L;

    }

    public void method3() {
        int a = 10;
        {
            int b = 11;
            b = a + b;
        }
        int c = 9;
    }

}
