package sorting;

public class CountingSort {
	public void sort(int[] array, int max) {
		int[] counts = new int[max + 1];

		// Set up counts
		for (var item : array) {
			counts[item]++;
		}

		// Put sorted result into an array
		int k = 0;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				array[k++] = i;
			}
		}
	}
}
