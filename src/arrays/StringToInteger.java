package arrays;

public class StringToInteger {
	public int myAtoi(String s) {
		int i = 0;
		int result = 0;
		int sign = 1;
		int strLength = s.length();

		if (strLength == 0) {
			return 0;
		}

		// Remove whitespaces at the beginning
		while (i < strLength && s.charAt(i) == ' ') {
			i++;
		}

		// Check if there is an optional sign
		if (i < strLength && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}

		while (i < strLength && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			if (result > Integer.MAX_VALUE / 10
					|| (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			result = result * 10 + (s.charAt(i) - '0');

			i++;
		}

		return result * sign;
	}
}
