class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];
        
        dp = new int[n + 2][2];

        for (int index = n - 1; index >= 1; index--) {
            dp[index][0] = Math.max(nums[index] + dp[index + 2][0], dp[index + 1][0]);
            
            if (index == n - 1) {
                dp[index][1] = 0;
            } else {
                dp[index][1] = Math.max(nums[index] + dp[index + 2][1], dp[index + 1][1]);
            }
        }

        return Math.max(nums[0] + dp[2][1], dp[1][0]);

    }

}
