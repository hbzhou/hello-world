package com.itsz.java.thread.concurrent;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAProblemTest {

    private static AtomicInteger init    = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("ABA问题的产生。。。");
        new Thread( ()-> {
            init.compareAndSet(100,101);
            init.compareAndSet(101, 100);
        }, "t1").start();


        new Thread( ()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = init.compareAndSet(100, 101);
            System.out.println(Thread.currentThread().getName()+"get result = " +result +"  init value:"+ init.get());
        }, "t2").start();

        Thread.sleep(2000);
        System.out.println("ABA问题的解决。。。");

        new Thread( ()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101, 100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
        }, "t3").start();


        new Thread( ()-> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"atomicStampedReference: reference="+atomicStampedReference.getReference()+" stamp = "+ stamp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"CAS result = "+ result +" reference="+ atomicStampedReference.getReference());

        },"t4").start();

    }
}
