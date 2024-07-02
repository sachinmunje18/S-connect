package com.jumpsearch.task7;

public class JumpSearch {
	public static int jumpSearch(int[] arr, int target) {
		int n = arr.length;
		int blockSize = (int) Math.sqrt(n);

		int left = 0;
		int right = blockSize;
		while (right < n && arr[right] <= target) {
			left = right;
			right += blockSize;
			if (right > n - 1) {
				right = n;
			}
		}

		for (int i = left; i < right; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		int target1 = 12;
		int target2 = 7;

		int index1 = jumpSearch(array, target1);
		if (index1 != -1) {
			System.out.println("Target " + target1 + " found at index: " + index1);
		} else {
			System.out.println("Target " + target1 + " not found in the array.");
		}

		int index2 = jumpSearch(array, target2);
		if (index2 != -1) {
			System.out.println("Target " + target2 + " found at index: " + index2);
		} else {
			System.out.println("Target " + target2 + " not found in the array.");
		}
	}
}
