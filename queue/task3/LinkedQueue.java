package com.queue.task3;

public class LinkedQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int count;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    public T dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue Underflow: Cannot remove from an empty queue");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count--;
        return data;
    }

    public T peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty: No elements to view");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Current size: " + queue.size());
    }
}
