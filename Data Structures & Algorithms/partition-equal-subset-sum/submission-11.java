class Solution {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[n][0] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= sum; j++) {
                boolean take = false;
                if (j - nums[i] >= 0)
                    take = dp[i + 1][j - nums[i]];
                boolean skip = dp[i + 1][j];
                dp[i][j] = take || skip;
            }
        }

        return dp[0][sum];

    }
}
