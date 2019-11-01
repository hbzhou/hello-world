package com.itsz.java.thread.lock_condition;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TreadTest {

     private static ReentrantLock locker = new ReentrantLock();//不公平锁

     private static Condition condition = locker.newCondition();

     private static Condition condition2 = locker.newCondition();

     private static boolean productedFlag = false;

     private static boolean consumeredFlag = false;



    public static void main(String[] args) throws Exception{
        Thread consumer = new Thread(new Consummer(),"consumer");
        Thread producer = new Thread(new Producer(),"producer" );

        consumer.start();

        TimeUnit.MILLISECONDS.sleep(500);

        producer.start();


    }


   static class Consummer implements Runnable {


       @Override
       public void run() {
           locker.lock();
           try {
               while (!productedFlag){
                   System.out.println(" no product to consumer,waiting....");
                   condition.await();
               }
               System.out.println("waiting finished");
               TimeUnit.MILLISECONDS.sleep(1000);
               System.out.println("consuming finished");
               condition2.signal();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               locker.unlock();
           }


       }



   }

    static class  Producer implements Runnable{

        @Override
        public void run() {
            locker.lock();
            try {
                while (!consumeredFlag){
                    System.out.println("no consumered t,waiting...");
                    condition2.await();
                }
                System.out.println("producting....");
                TimeUnit.MILLISECONDS.sleep(1000);
                condition.signal();
            }catch (InterruptedException e){

            }finally {
                locker.unlock();
            }


        }
    }


}



