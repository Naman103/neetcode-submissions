class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums)
            target += num;
        
        if (target % 2 != 0)
            return false;
        
        return sumPartition(nums, 0, target/2);
    }

    private boolean sumPartition(int[] nums, int curIndex, int target) {
        if (target == 0)
            return true;
        
        if (curIndex >= nums.length || target < 0)
            return false;
        
        return sumPartition(nums, curIndex + 1, target - nums[curIndex]) || sumPartition(nums, curIndex + 1, target);
    }
}
