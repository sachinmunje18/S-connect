package com.linkedlist.task4;

public class SimpleLinkedList<T> {
    private Node<T> start;
    private int count;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public SimpleLinkedList() {
        start = null;
        count = 0;
    }

    public void addElement(T element) {
        Node<T> newNode = new Node<>(element);
        if (start == null) {
            start = newNode;
        } else {
            Node<T> current = start;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }

    public T removeElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<T> prev = null;
        Node<T> current = start;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            start = start.next;
        } else {
            prev.next = current.next;
        }
        count--;
        return current.value;
    }

    public T retrieveElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<T> current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void displayElements() {
        Node<T> current = start;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();

        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.addElement(40);

        System.out.print("Elements in the list: ");
        list.displayElements(); // Output: 10 20 30 40

        int removedElement = list.removeElement(2); // Removing element at index 2
        System.out.println("Removed element: " + removedElement); // Output: Removed element: 30

        int retrievedElement = list.retrieveElement(1); // Retrieving element at index 1
        System.out.println("Retrieved element: " + retrievedElement); // Output: Retrieved element: 20

        System.out.println("Is list empty? " + list.isEmpty()); // Output: Is list empty? false

        System.out.println("Current size of the list: " + list.size()); // Output: Current size of the list: 3
    }
}
