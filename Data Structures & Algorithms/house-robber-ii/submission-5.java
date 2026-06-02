class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1][2];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        dp[0][1] = nums[0] + rob(nums, 2, 1);
        dp[0][0] = rob(nums, 1, 0);

        return Math.max(dp[0][1], dp[0][0]);
    }

    public int rob (int[] nums, int index, int firstHouseRobbed) {
        if (index >= nums.length) {
            if (index == nums.length)
                dp[index][firstHouseRobbed] = 0;
            return 0;
        }
        if (dp[index][firstHouseRobbed] != -1)
            return dp[index][firstHouseRobbed];

        if (index == nums.length - 1 && firstHouseRobbed == 1) {
            dp[index][firstHouseRobbed] = 0;
            return 0;
        }

        dp[index][firstHouseRobbed] =  Math.max(nums[index] + rob(nums, index + 2, firstHouseRobbed),
         rob(nums, index + 1, firstHouseRobbed));

         return dp[index][firstHouseRobbed];
    }
}
