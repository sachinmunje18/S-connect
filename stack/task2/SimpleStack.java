package com.stack.task2;

public class SimpleStack {
    private int[] elements;
    private int currentSize;
    private int maxSize;

    public SimpleStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
        currentSize = 0;
    }

    public void push(int value) {
        if (currentSize == maxSize) {
            System.out.println("Stack Overflow: Cannot add " + value);
            return;
        }
        elements[currentSize++] = value;
    }

    public int pop() {
        if (currentSize == 0) {
            throw new IllegalStateException("Stack Underflow: Cannot remove element from an empty stack");
        }
        return elements[--currentSize];
    }

    public int peek() {
        if (currentSize == 0) {
            throw new IllegalStateException("Stack is empty: No elements to view");
        }
        return elements[currentSize - 1];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Current size: " + stack.size());
    }
}
