class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1][2];
        if(nums.length == 1) return nums[0];
        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return Math.max(maxMoney(nums, 0, 0), maxMoney(nums, 1, 1));
    }

    public int maxMoney(int[] nums, int index, int firstIndexTaken) {
        if(dp[index][firstIndexTaken] != -1)
            return dp[index][firstIndexTaken];
        
        if (index >= nums.length) {
            dp[index][firstIndexTaken] = 0;
            return 0; 
        }
        
        if(index == nums.length - 1 && firstIndexTaken != 0) {
            dp[index][firstIndexTaken] = nums[index];
            return nums[index];
        } else if(index == nums.length - 1) {
            dp[index][firstIndexTaken] = 0;
            return 0;
        }
        
        dp[index][firstIndexTaken] = Math.max(maxMoney(nums, index + 1, firstIndexTaken), nums[index] + maxMoney(nums, index + 2, firstIndexTaken));

        return dp[index][firstIndexTaken];

    }
}
