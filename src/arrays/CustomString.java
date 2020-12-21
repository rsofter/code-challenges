package arrays;

public class CustomString {
	public int indexOf(String haystack, String needle) {
		int needleLength = needle.length();
		if (needleLength == 0) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int matchLength = 0;
		int haystackLength = haystack.length();

		while (j < haystackLength) {
			if (haystack.charAt(j) != needle.charAt(i)) {
				i = 0;
				j = j - matchLength + 1;
				matchLength = 0;
			} else {
				matchLength++;
				if (matchLength == needleLength) {
					return j - needleLength + 1;
				}
				i++;
				j++;
			}
		}

		return -1;
	}
}
