package com.itsz.java.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class LatchCountDownTest {

    public static void main(String[] args) throws Exception{

        CountDownLatch  countDownLatch = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName()+" is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" finished");
                countDownLatch.countDown();
            }).start();
        }
        System.out.println("waiting for 2 thread running finish");
        countDownLatch.await();
        System.out.println(" 2 thread running finish");
        System.out.println(" keep running on main thread"+ Thread.currentThread().getName());


    }
}
