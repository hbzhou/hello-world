package com.itsz.java.jvm;

public class JVMMainTest {

    public static void main(String[] args) {
        System.out.println("最大内存: ");
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024+"MB");
        System.out.println("可用内存: ");
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024+"MB");
        System.out.println("已使用内存: ");
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024+"MB");
    }


}
