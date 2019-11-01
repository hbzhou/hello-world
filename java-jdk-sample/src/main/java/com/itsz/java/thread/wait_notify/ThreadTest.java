package com.itsz.java.thread.wait_notify;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private static Object lock = new Object();  //object lock

    private static boolean flag = false;

    public static void main(String[] args)throws Exception {
        Thread consumer = new Thread(new Consumer(),"consumer thread");
        Thread producer = new Thread(new Producer(),"producer thread");

        consumer.start();
        Thread.sleep(1000);
        producer.start();

        producer.join();
        consumer.join();


    }


    static class Consumer implements Runnable{

        @Override
        public void run() {
            System.out.println("进入消费者线程");
            System.out.println("wait flag 1:" + flag);
            synchronized (lock){
                while (!flag){
                    try {
                        System.out.println("no resource for producer, waiting");
                        lock.wait();
                        System.out.println("finished waiting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            System.out.println("wait flag 2:" + flag);
            System.out.println("消费");
            System.out.println("退出消费者线程");

        }
    }


    static class Producer implements Runnable{

        @Override
        public void run() {

            synchronized (lock){
                System.out.println("producer thread enter");
                System.out.println("producing......");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("produce finished");
                    flag=true;
                    lock.notify();
                    System.out.println("producer thread out");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }



}
