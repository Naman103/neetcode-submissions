class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int curMax = Integer.MIN_VALUE;
        int left = 0, right = k;
        while (right <= n) {
            result[left] = getMaxValue(nums, left, right - 1);
            left++;
            right++;
        }

        return result;
    }

    public int getMaxValue(int[] nums, int left, int right) {
        int maxValue = Integer.MIN_VALUE;
        while (left <= right) {
            maxValue = Math.max(maxValue, nums[left++]);
        }

        return maxValue;
    }
}
