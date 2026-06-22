class Solution {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        return canPartition(nums, 0, sum);

    }

    private boolean canPartition(int[] nums, int index, int target) {
        if (index >= nums.length || target < 0)
            return false;
        
        if (target == 0)
            return true;
        
        return canPartition(nums, index + 1, target - nums[index]) || canPartition(nums, index + 1, target);
    }


}
