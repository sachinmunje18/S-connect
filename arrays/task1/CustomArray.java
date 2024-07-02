package com.arrays.task1;

public class CustomArray {
    private int[] elements;
    private int count;
    private int capacity;

    public CustomArray() {
        capacity = 2;
        elements = new int[capacity];
        count = 0;
    }

    public void insert(int value) {
        if (count == capacity) {
            expandCapacity();
        }
        elements[count++] = value;
    }

    private void expandCapacity() {
        capacity *= 2;
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, count);
        elements = newElements;
    }

    public int retrieve(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        return elements[index];
    }

    public void modify(int index, int value) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        elements[index] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--count] = 0; // Optional: clear the last element
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray();

        // Adding elements
        customArray.insert(5);
        customArray.insert(8);
        customArray.insert(12);
        customArray.insert(20);
        customArray.display(); // Output: 5 8 12 20

        // Retrieving an element
        System.out.println("Element at index 2: " + customArray.retrieve(2)); // Output: 12

        // Modifying an element
        customArray.modify(2, 15);
        customArray.display(); // Output: 5 8 15 20

        // Removing an element
        customArray.remove(1);
        customArray.display(); // Output: 5 15 20
    }
}
