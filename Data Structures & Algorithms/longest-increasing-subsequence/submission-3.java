class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int LIS = dp[i + 1][j + 1];
                if (j == -1 || nums[i] > nums[j])
                    LIS = Math.max(LIS, 1 + dp[i + 1][i + 1]);
                dp[i][j + 1] = LIS;
            }
        }

        //lengthOfLIS(nums, 0, -1);
        return dp[0][0];
    }

    // public int lengthOfLIS(int[] nums, int curIndex, int prevIndex) {
    //     if (curIndex == nums.length)    
    //         return 0;
        
    //     if (dp[curIndex][prevIndex + 1] != null)
    //         return dp[curIndex][prevIndex + 1];
        
    //     int taken = 0, notTaken;

    //     if (prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
    //         taken = 1 + lengthOfLIS(nums, curIndex + 1, curIndex);
    //     }

    //     notTaken = lengthOfLIS(nums, curIndex + 1, prevIndex);
    //     dp[curIndex][prevIndex + 1] = Math.max(taken, notTaken);
    //     return dp[curIndex][prevIndex + 1];
    // }
}
