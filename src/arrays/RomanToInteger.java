package arrays;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int last = s.length() - 1;
		result += map.get(s.charAt(last));

		for (int i = last - 1; i >= 0; i--) {
			int currentValue = map.get(s.charAt(i));
			int lastValue = map.get(s.charAt(i + 1));
			if (currentValue < lastValue) {
				result -= currentValue;
			} else {
				result += currentValue;
			}
		}

		return result;
	}
}
