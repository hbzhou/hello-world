package com.itsz.java.thread.concurrent;

public class VolatileAtomicTest {

    public static void main(String[] args) throws InterruptedException {
        MyDataPlus myDataPlus = new MyDataPlus();

        for (int i = 0; i <500 ; i++) {
            for (int j = 0; j < 1000; j++) {
                new Thread(()->{
                  //  myDataPlus.increment();
                    myDataPlus.addAtomic();
                }).start();
            }

        }

        while (Thread.activeCount()>2){

        }
        System.out.println(Thread.currentThread().getName()+" -number=" +myDataPlus.atomicInteger.get());
    }
}
