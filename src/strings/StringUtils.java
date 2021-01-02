package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {
	public static int countVowels(String str) {
		if (str == null) {
			return 0;
		}

		int count = 0;
		HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		for (var ch : str.toLowerCase().toCharArray()) {
			if (vowels.contains(ch)) {
				count++;
			}
		}

		return count;
	}

	public static String reverseString(String str) {
		if (str == null) {
			return "";
		}

		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}

		return reversed.toString();

	}

	public static String reverseWords(String sentence) {
		if (sentence == null) {
			return "";
		}

		String[] words = sentence.trim().split(" ");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}

	public static boolean areRotations(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}

		return (str1.length() == str2.length() && (str1 + str1).contains(str2));
	}

	public static String removeDuplicates(String str) {
		if (str == null) {
			return "";
		}

		Set<Character> seen = new HashSet<>();
		StringBuilder output = new StringBuilder();

		for (var ch : str.toCharArray()) {
			if (!seen.contains(ch)) {
				output.append(ch);
				seen.add(ch);
			}
		}

		return output.toString();
	}

	public static char getMaxOccuringChar(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException();
		}

		// Counting frequencies for chars
		Map<Character, Integer> frequencies = new HashMap<>();
		for (var ch : str.toCharArray()) {
			if (frequencies.containsKey(ch)) {
				frequencies.replace(ch, frequencies.get(ch) + 1);
			} else {
				frequencies.put(ch, 1);
			}
		}

		// Finding the most frequent char
		int mostFrequent = 0;
		char mostFrequentChar = ' ';
		for (var key : frequencies.keySet()) {
			if (frequencies.get(key) > mostFrequent) {
				mostFrequent = frequencies.get(key);
				mostFrequentChar = key;
			}
		}

		return mostFrequentChar;
	}

	public static String capitalizeWords(String sentence) {
		if (sentence == null || sentence.trim().isEmpty()) {
			return "";
		}

		String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
		}

		return String.join(" ", words);
	}

	// O(n log n)
	public static boolean areAnagramsSort(String str1, String str2) {
		if (str1.length() != str2.length() || str1 == null || str2 == null) {
			return false;
		}

		// O(n)
		var array1 = str1.toLowerCase().toCharArray();
		// O (n log n)
		Arrays.sort(array1);

		// O(n)
		var array2 = str2.toLowerCase().toCharArray();
		// O (n log n)
		Arrays.sort(array2);

		return Arrays.equals(array1, array2);
	}

	public static boolean areAnagramsASCI(String str1, String str2) {
		if (str1.length() != str2.length() || str1 == null || str2 == null) {
			return false;
		}

		final int ENGlISH_ALPHABET = 26;
		int[] frequencies = new int[ENGlISH_ALPHABET];

		str1 = str1.toLowerCase();
		for (int i = 0; i < str1.length(); i++) {
			frequencies[str1.charAt(i) - 'a']++;
		}

		str2 = str2.toLowerCase();
		for (int i = 0; i < str2.length(); i++) {
			int index = str2.charAt(i) - 'a';
			if (frequencies[index] == 0) {
				return false;
			}
			frequencies[index]--;
		}

		return true;
	}

	public static boolean isPalindrome(String str) {
		if (str == null) {
			return false;
		}

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left++) != str.charAt(right--)) {
				return false;
			}
		}

		return true;
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", " ").split("\\s+");
		Map<String, Integer> wordCount = new HashMap<>();
		Set<String> bannedWords = new HashSet<>();

		for (var word : banned) {
			bannedWords.add(word);
		}

		for (var word : words) {
			if (!bannedWords.contains(word)) {
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
			}
		}

		return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
