package com.itsz.data.structure.stack;

import lombok.Data;

@Data
public class ArrayStack {

    private int maxSize;

    private int[] array;

    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public void push(int data) {
        if (isFull()) {
            return;
        }

        array[++top] = data;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int pop() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("stack is empty");
        }
        int value = array[top];
        top--;
        return value;
    }

    public boolean isEmpty() {
        return top == -1;

    }
}
