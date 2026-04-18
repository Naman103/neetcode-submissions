class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) 
            return nums[0];

        dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return Math.max(rob(nums, 0, 1), rob(nums, 1, 0));
    }

    public int rob(int[] nums, int idx, int firstHouseSelected) {
        if (idx >= nums.length)
            return 0;
        
        if (idx == nums.length - 1 && firstHouseSelected == 1) 
            return 0;
        
        if(dp[idx][firstHouseSelected] != -1)
            return dp[idx][firstHouseSelected];
        
        dp[idx][firstHouseSelected] = Math.max(rob(nums, idx + 1, firstHouseSelected), nums[idx] + rob(nums, idx + 2, firstHouseSelected));
        return dp[idx][firstHouseSelected];
    }
}
