class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];
        

        int[] result = new int[n];
        int postfix = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] = prefix[i] * postfix;
            postfix = nums[i] * postfix;
        }

        return result;
    }
}  
