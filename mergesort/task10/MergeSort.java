package com.mergesort.task10;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }

        int[] tempArray = new int[arr.length];
        mergeSort(arr, tempArray, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left and right halves
            mergeSort(arr, tempArray, left, mid);
            mergeSort(arr, tempArray, mid + 1, right);

            // Merge the sorted halves
            merge(arr, tempArray, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] tempArray, int left, int mid, int right) {
        // Copy elements to temporary array
        for (int i = left; i <= right; i++) {
            tempArray[i] = arr[i];
        }

        int i = left; // Initial index for left subarray
        int j = mid + 1; // Initial index for right subarray
        int k = left; // Initial index for merged subarray

        // Merge the temporary arrays
        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                arr[k] = tempArray[i];
                i++;
            } else {
                arr[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            arr[k] = tempArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            arr[k] = tempArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Array before sorting:");
        printArray(array);

        mergeSort(array);

        System.out.println("\nArray after sorting:");
        printArray(array);
    }

    // Utility method to print the elements of an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
