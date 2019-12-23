package com.itsz.data.structure.queue;


/**
 * front: 队列的第一个元素
 * rear: 队列最后一个元素的后一个位置，约定空出一个空间。
 * maxSize: 最大空间
 * 队列的size: (rear +maxsize-front)% maxsize
 * (1+3-0)% 3 = 1;
 */
public class CircleQueue {

    private int maxSize;

    private int rear;

    private int front;

    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.rear = 0;
        this.front = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;

    }

    public int get() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Queue is empty");
        }
        int data = arr[front];
        front = (front + 1) % maxSize;
        return data;
    }


    public void show() {
        if (isEmpty()) {
            System.out.println("isEmpty");
        }
        System.out.println(size());
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d \t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int head() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Queue is empty");
        }
        return arr[front];
    }


}
