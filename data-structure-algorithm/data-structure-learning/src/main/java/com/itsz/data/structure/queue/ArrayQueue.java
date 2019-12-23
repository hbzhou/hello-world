package com.itsz.data.structure.queue;


import java.util.Arrays;

public class ArrayQueue {

    private int maxSize;

    private int front;

    private int rear;

    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }


    public boolean addQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        array[++rear] = data;
        return true;
    }


    public int get() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Queue is empty");
        }
        return array[++front];
    }

    public void show() {
        Arrays.stream(array).forEach(value -> {
            System.out.printf("%d\t", value);
        });
        System.out.println("\r\n");

        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("arr[%d]=%d\t", i, array[i]);
        }
        System.out.println();
    }


    private boolean isFull() {
        return rear == maxSize - 1;
    }

    private boolean isEmpty() {
        return front == rear;
    }
}
