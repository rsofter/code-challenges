package arrays;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSumSorted(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			}

			if (sum > target) {
				right--;
			} else {
				left++;
			}
		}

		return null;
	}
}
