class Solution {
    public int maxSubArray(int[] nums) {
        int sum, maxSum = Integer.MIN_VALUE;
        for(int start = 0; start < nums.length; start++) {
            sum = nums[start];
            maxSum = Math.max(sum, maxSum);
            for(int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                maxSum = Math.max(sum, maxSum);
            }
        
        }

        return maxSum;
    }

    
}
