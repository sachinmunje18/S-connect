package com.heapsort.task11;

public class HeapSort {
	public static void heapSort(int[] arr) {
		int n = arr.length;

		// Build max heap
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// Extract elements from heap one by one
		for (int i = n - 1; i > 0; i--) {
			// Swap root (largest element) with last element
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Heapify the reduced heap
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
		int left = 2 * i + 1; // Left child
		int right = 2 * i + 2; // Right child

		// If left child is larger than root
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		// If right child is larger than largest so far
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		int[] array = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("Array before sorting:");
		printArray(array);

		heapSort(array);

		System.out.println("\nArray after sorting:");
		printArray(array);
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
