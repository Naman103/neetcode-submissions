class Solution {
    Integer[] result = new Integer[101];
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        result[0] = nums[0];
        result[1] = Math.max(nums[1], nums[0]);
        return rob(nums, nums.length - 1);
    }

    public int rob(int[] nums, int n) {
        if (result[n] != null)
            return result[n];
        
        result[n] = Math.max(nums[n] + rob(nums, n - 2), rob(nums, n - 1)); 
        return result[n];
    }
}
