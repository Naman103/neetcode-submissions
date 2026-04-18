class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = k - 1;
        while(right < nums.length) {
            result[left] = getMax(nums, left, right);
            left++;
            right++;
        }

        return result;
    }

    public int getMax(int[] nums, int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        while(start <= end) {
            maxValue = Math.max(maxValue, nums[start]);
            start++;
        }

        return maxValue;
    }
}
