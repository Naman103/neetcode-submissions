class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        int n = nums.length;
        dp = new Boolean[n][sum + 1];
        canPartition(nums, 0, sum);
        //printDpArray(dp, n, sum);
        return dp[0][sum];

    }

    private void printDpArray(Boolean[][] dp, int n, int sum) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
    private boolean canPartition(int[] nums, int index, int target) {
        if (index >= nums.length || target < 0)
            return false;
        
        if (dp[index][target] != null)
            return dp[index][target];

        if (target == 0) {
            dp[index][target] = true;
            return dp[index][target];
        }
        
        dp[index][target] = canPartition(nums, index + 1, target - nums[index]) || canPartition(nums, index + 1, target);
        return dp[index][target];
    }


}
