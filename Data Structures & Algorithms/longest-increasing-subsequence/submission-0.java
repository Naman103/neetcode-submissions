class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxCount = 1;
        for(int i = 0; i < nums.length - 1; i++)
            maxCount = Math.max(maxCount, dfs(nums, i + 1, i));
        
        return maxCount;
    }

    public int dfs(int[] nums, int curIndex, int prevIndex) {
        if(curIndex >= nums.length)
            return 1;
        
        if(nums[curIndex] > nums[prevIndex]) {
            return Math.max(1 + dfs(nums, curIndex+1, curIndex), dfs(nums, curIndex + 1, prevIndex));
        } else {
            return dfs(nums, curIndex + 1, prevIndex);
        }
    }
}
