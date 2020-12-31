package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class LetterCombinations {
	HashMap<String, String> map = new HashMap<>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	List<String> output = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.length() != 0) {
			backtrack("", digits);
		}

		return output;
	}

	private void backtrack(String combination, String nextDigits) {
		// If there is no more digits to check.
		if (nextDigits.length() == 0) {
			// The combination is done.
			output.add(combination);
		} else {
			// If there are still digits to check.
			String digit = nextDigits.substring(0, 1);
			String letters = map.get(digit);
			// Iterate over all letters which map the next available digit
			for (int i = 0; i < letters.length(); i++) {
				String letter = letters.substring(i, i + 1);
				// Append the current letter to the combination and proceed to the next digits.
				backtrack(combination + letter, nextDigits.substring(1));
			}
		}
	}
}
