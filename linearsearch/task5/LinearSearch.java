package com.linearsearch.task5;

public class LinearSearch {
	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i; 
			}
		}
		return -1; 
	}

	public static void main(String[] args) {
		int[] array = { 5, 8, 3, 2, 9, 1, 7 };
		int target1 = 3;
		int target2 = 10;

		int index1 = linearSearch(array, target1);
		if (index1 != -1) {
			System.out.println("Target " + target1 + " found at index: " + index1);
		} else {
			System.out.println("Target " + target1 + " not found in the array.");
		}

		int index2 = linearSearch(array, target2);
		if (index2 != -1) {
			System.out.println("Target " + target2 + " found at index: " + index2);
		} else {
			System.out.println("Target " + target2 + " not found in the array.");
		}
	}
}
