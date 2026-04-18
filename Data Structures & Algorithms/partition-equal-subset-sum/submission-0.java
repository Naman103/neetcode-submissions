class Solution {
    public boolean canPartition(int[] nums) {
        int sumLeft = 0, sumRight = 0;
        for(int num : nums)
            sumRight += num;
        
        return dfs(nums, 0, sumLeft, sumRight);
    }

    public boolean dfs(int[] nums,int leftIndex, int sumLeft, int sumRight) {
        if(leftIndex >= nums.length)
            return false;

        if(sumLeft == sumRight)
            return true;
        
        return dfs(nums, leftIndex + 1, sumLeft + nums[leftIndex], sumRight - nums[leftIndex]) || dfs(nums, leftIndex + 1, sumLeft, sumRight);

    }
}
