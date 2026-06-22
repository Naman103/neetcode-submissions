class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n + 1];
        lengthOfLIS(nums, 0, -1);
        return dp[0][0];
    }

    public int lengthOfLIS(int[] nums, int curIndex, int prevIndex) {
        if (curIndex == nums.length)    
            return 0;
        
        if (dp[curIndex][prevIndex + 1] != null)
            return dp[curIndex][prevIndex + 1];
        
        int taken = 0, notTaken;

        if (prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
            taken = 1 + lengthOfLIS(nums, curIndex + 1, curIndex);
        }

        notTaken = lengthOfLIS(nums, curIndex + 1, prevIndex);
        dp[curIndex][prevIndex + 1] = Math.max(taken, notTaken);
        return dp[curIndex][prevIndex + 1];
    }
}
