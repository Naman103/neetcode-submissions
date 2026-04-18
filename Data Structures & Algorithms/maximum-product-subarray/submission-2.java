class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int minProduct = 1, maxProduct = 1;

        for(int i = 0; i < n; i++) {
            int temp1 = maxProduct * nums[i], temp2 = minProduct * nums[i];
            maxProduct = Math.max(Math.max(temp1, temp2), nums[i]);
            minProduct = Math.min(Math.min(temp1, temp2), nums[i]);
            res = Math.max(res, maxProduct);
        }

        return res;
    }

}
