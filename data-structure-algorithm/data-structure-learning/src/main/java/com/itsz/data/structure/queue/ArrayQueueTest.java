package com.itsz.data.structure.queue;

import org.junit.Test;

import java.util.Scanner;

public class ArrayQueueTest {

    private static ArrayQueue arrayQueue = new ArrayQueue(5);
    private static boolean flag = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("[a]= addQueue");
            System.out.println("[g]= get");
            System.out.println("[s]= show");
            System.out.println("[e]= exit");
            String input = scanner.nextLine();
            switch (input) {
                case "g":
                    try {
                        int data = arrayQueue.get();
                        System.out.println(data);
                    } catch (IllegalAccessException e) {
                        System.out.println("queue is empty");
                    }
                    break;
                case "a":
                    System.out.println("please input a number");
                    int data = new Scanner(System.in).nextInt();
                    boolean bool = arrayQueue.addQueue(data);
                    if (bool) {
                        System.out.println("add success");
                    } else {
                        System.out.println("add failed");
                    }
                    break;
                case "s":
                    arrayQueue.show();
                    break;
                case "e":
                    flag = false;
                    break;
                default:

            }

        }

    }
}
