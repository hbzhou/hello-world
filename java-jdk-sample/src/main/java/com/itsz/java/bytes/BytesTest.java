package com.itsz.java.bytes;

public class BytesTest {

    public static void main(String[] args) {

        long updateFlag = 0;
        int flag = 0x00;
        int flag2 = 0x02;
        int flag4 = 0x04;
        int flag8 = 0x08;
        updateFlag = updateFlag | flag;
        updateFlag = updateFlag | flag2;
        updateFlag = updateFlag | flag4;
        updateFlag = updateFlag | flag8;
        System.out.println(updateFlag);
    }
}
