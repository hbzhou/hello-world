package com.itsz.java.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new MyThread(cyclicBarrier));
        Thread t2 = new Thread(new MyThread(cyclicBarrier));
        Thread t3 = new Thread(new MyThread(cyclicBarrier));
        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread extends  Thread {

        private CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"finish task");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("waiting for all the thread finish task");


        }
    }
}
