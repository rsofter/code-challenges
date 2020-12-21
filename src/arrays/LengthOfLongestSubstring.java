package arrays;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();
		int left = 0;
		int right = 0;
		int maxLength = 0;

		while (right < s.length()) {
			if (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			} else {
				set.add(s.charAt(right));
				maxLength = Math.max(maxLength, right - left + 1);
				right++;
			}
		}

		return maxLength;
	}
}
