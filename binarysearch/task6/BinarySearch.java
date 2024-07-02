package com.binarysearch.task6;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int target1 = 7;
        int target2 = 10;

        int index1 = binarySearch(array, target1);
        if (index1 != -1) {
            System.out.println("Target " + target1 + " found at index: " + index1);
        } else {
            System.out.println("Target " + target1 + " not found in the array.");
        }

        int index2 = binarySearch(array, target2);
        if (index2 != -1) {
            System.out.println("Target " + target2 + " found at index: " + index2);
        } else {
            System.out.println("Target " + target2 + " not found in the array.");
        }
    }
}
