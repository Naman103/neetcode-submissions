class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return Math.max(dp[0], dp[1]);
    }

    public int maxMoney(int[] nums, int index) {
        if(index >= nums.length)
            return 0;
        
        return Math.max(nums[index] + maxMoney(nums, index + 2), maxMoney(nums, index + 1));
    }
}
