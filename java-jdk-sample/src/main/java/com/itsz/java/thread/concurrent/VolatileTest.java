package com.itsz.java.thread.concurrent;

public class VolatileTest {

    public static void main(String[] args) {

        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in, number =" + myData.number);
           /* try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "execute finished, number = " + myData.number);
        }).start();


        new Thread( ()-> {
            System.out.println(Thread.currentThread().getName()+"come int ");
            while (myData.number!=60){

            }
            System.out.println(Thread.currentThread().getName()+"execute finished, number = "+ myData.number);
        }).start();


        while (myData.number == 0) {

        }
        System.out.println("execution finished");

    }


}

