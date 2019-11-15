package com.itsz.java.thread.concurrent;


import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(8);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }

    }

   static class Worker extends  Thread {


        private int num;

        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }


        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker No. " +num +"正在使用机器");
                Thread.sleep(3000);
                semaphore.release();
                System.out.println("worker No." +num +"使用结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
