package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length && diff != 0; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}

				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

		return target - diff;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (dups.add(nums[i])) {
				for (int j = i + 1; j < nums.length; j++) {
					int complement = -nums[i] - nums[j];
					if (seen.containsKey(complement) && seen.get(complement) == i) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
						Collections.sort(triplet);
						res.add(triplet);
					}
					seen.put(nums[j], i);
				}
			}
		}

		return new ArrayList(res);
	}

	public List<List<Integer>> threeSumSortedArray(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSum(nums, i, result);
			}
		}
		return result;
	}

	private void twoSum(int[] numbers, int i, List<List<Integer>> res) {
		var seen = new HashSet<Integer>();

		for (int j = i + 1; j < numbers.length; j++) {
			int complement = -numbers[i] - numbers[j];
			if (seen.contains(complement)) {
				res.add(Arrays.asList(numbers[i], numbers[j], complement));
				while (j + 1 < numbers.length && numbers[j - 1] == numbers[j]) {
					j++;
				}
			}
			seen.add(numbers[j]);
		}
	}

	private void twoSumII(int[] numbers, int i, List<List<Integer>> res) {
		int left = i + 1;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[i] + numbers[left] + numbers[right];
			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				res.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
				left++;
				right--;

				while (left < right && numbers[left] == numbers[left - 1]) {
					++left;
				}
			}
		}
	}
}
