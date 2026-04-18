class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, -1);

    }

    public int dfs(int[] nums, int curIndex, int prevIndex) {
        if(curIndex == nums.length)
            return 0;
        
        int taken = 0, notTaken;

        //When taking this index into consideration
        if(prevIndex == -1 || nums[curIndex] > nums[prevIndex]) {
            taken = 1 + dfs(nums, curIndex + 1, curIndex);
        }

        //When not taking this index into consideration
        notTaken = dfs(nums, curIndex + 1, prevIndex);

        return Math.max(taken, notTaken);
    }
}
