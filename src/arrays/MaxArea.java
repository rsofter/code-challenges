package arrays;

public class MaxArea {
	public int maxArea(int[] height) {
		int maxContainerArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int currentVolume = Math.min(height[left], height[right]) * (right - left);
			maxContainerArea = Math.max(maxContainerArea, currentVolume);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}

		return maxContainerArea;
	}
}
