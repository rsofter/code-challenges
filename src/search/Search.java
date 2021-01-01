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
		// return binarySearchRecursive(array, target, 0, array.length - 1);
		return binarySearchIterative(array, target);
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

	private int binarySearchIterative(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (array[middle] == target) {
				return middle;
			}

			if (target < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}

	public int ternarySearch(int[] array, int target) {
		return ternarySearch(array, target, 0, array.length - 1);
	}

	private int ternarySearch(int[] array, int target, int left, int right) {
		// Base condition
		if (left > right) {
			return -1;
		}

		// Calculate 3 partions
		int partitionSize = (right - left) / 3;
		int mid1 = left + partitionSize;
		int mid2 = right - partitionSize;

		if (array[mid1] == target) {
			return mid1;
		}

		if (array[mid2] == target) {
			return mid2;
		}

		if (target < array[mid1]) {
			return ternarySearch(array, target, left, mid1 - 1);
		}

		if (target > array[mid2]) {
			return ternarySearch(array, target, mid2 + 1, right);
		}

		return ternarySearch(array, target, mid1 + 1, mid2 - 1);
	}

	public int jumpSearch(int[] array, int target) {
		int blockSize = (int) Math.sqrt(array.length);
		int start = 0;
		int next = blockSize;

		// Finding a block, where the target item might be
		while (start < array.length && array[next - 1] < target) {
			// Mode to the next block
			start = next;
			next += blockSize;
			if (next > array.length) {
				next = array.length;
			}
		}

		// Linear Search inside the block
		for (int i = start; i < next; i++) {
			if (array[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public int exponentialSearch(int[] array, int target) {
		int bound = 1;
		// Finding the range, where the target value might be
		while (bound < array.length && array[bound] < target) {
			bound *= 2;
		}

		int left = bound / 2;
		int right = Math.min(bound, array.length - 1);

		return binarySearchRecursive(array, target, left, right);
	}
}
