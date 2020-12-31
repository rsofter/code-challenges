package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	public void sort(int[] array, int numberOfBuckets) {
		int i = 0;
		for (var bucket : createBuckets(array, numberOfBuckets)) {
			Collections.sort(bucket);
			for (var item : bucket) {
				array[i++] = item;
			}
		}
	}

	private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList<>();

		// Init buckets with empty lists
		for (var i = 0; i < numberOfBuckets; i++) {
			buckets.add(new ArrayList<>());
		}

		// Distribute array's items through the buckets
		for (var item : array) {
			buckets.get(item / numberOfBuckets).add(item);
		}
		return buckets;
	}

}
