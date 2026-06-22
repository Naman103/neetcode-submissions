class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums)
            target += num;
        
        if (target % 2 != 0)
            return false;
        
        int n = nums.length;
        dp = new Boolean[n + 1][target/2 + 1];
        return sumPartition(nums, 0, target/2);
    }

    private boolean sumPartition(int[] nums, int curIndex, int target) {
        if (curIndex >= nums.length || target < 0) {
            return false;
        }

        if (dp[curIndex][target] != null)
            return dp[curIndex][target];
        
        if (target == 0) {
            dp[curIndex][target] = true;
            return true;
        }
    
        
        dp[curIndex][target] = sumPartition(nums, curIndex + 1, target - nums[curIndex]) || sumPartition(nums, curIndex + 1, target);
        return dp[curIndex][target];
    }
}
