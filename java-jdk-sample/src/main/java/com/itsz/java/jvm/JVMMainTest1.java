package com.itsz.java.jvm;

import java.util.ArrayList;
import java.util.List;

public class JVMMainTest1 {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<Object>();
        for (int i = 0; i < 10; i++) {
            Byte[] b = new Byte[1 * 1024 * 1024];
            objectList.add(b);
        }

    }
}
