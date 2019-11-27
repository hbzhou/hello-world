package com.itsz.java.thread.concurrent;

public class SingletonConcurrentTest {

    public static void main(String[] args) {
/*        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());*/


        for (int i = 0; i < 1000; i++) {
            new Thread( ()-> {
               Singleton.getInstance();
            }).start();

        }


    }

}
