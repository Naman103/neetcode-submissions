class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];
        prefixProduct[0] = 1;
        postfixProduct[n - 1] = 1;
        for(int i = 1 ; i < n; i++)
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        
        for(int i = n - 2; i >= 0; i--)
            postfixProduct[i] = postfixProduct[i + 1] * nums[i + 1];

        int[] result = new int[n];
        for(int i = 0; i < n; i++) 
            result[i] = prefixProduct[i] * postfixProduct[i];
        
        return result;
    }
}  
