package com.itsz.data.structure.queue;

import java.util.Scanner;

public class CircleQueueTest {

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);
        boolean loop = true;

        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("[a]= add");
            System.out.println("[g]= get");
            System.out.println("[s]= show");
            System.out.println("[e]= exit");
            System.out.println("[h]= header");
            String input = scanner.nextLine();
            switch (input) {
                case "g":
                    try {
                        System.out.println(circleQueue.get());
                    } catch (IllegalAccessException e) {
                        System.out.println("queue is empty");
                    }
                    break;
                case "a":
                    System.out.println("please input a number");
                    int data = scanner.nextInt();
                    circleQueue.add(data);
                    break;
                case "s":
                    circleQueue.show();
                    break;
                case "e":
                    loop = false;
                    break;
                case "h":
                    try {
                        System.out.println(circleQueue.head());
                    } catch (IllegalAccessException e) {
                        System.out.println("queue is empty");
                    }
                    break;
                default:

            }
        }
    }
}
