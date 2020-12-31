package search;

public class Search {
	public int linearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public int binarySearch(int[] array, int target) {
		return binarySearchRecursive(array, target, 0, array.length - 1);
	}

	private int binarySearchRecursive(int[] array, int target, int left, int right) {
		// Base condition
		if (right < left) {
			return -1;
		}

		int middle = (left + right) / 2;
		if (array[middle] == target) {
			return middle;
		}

		// Searching the target in the left part
		if (target < array[middle]) {
			return binarySearchRecursive(array, target, left, middle - 1);
		}

		// Searching the target in the right part
		return binarySearchRecursive(array, target, middle + 1, right);
	}
}
