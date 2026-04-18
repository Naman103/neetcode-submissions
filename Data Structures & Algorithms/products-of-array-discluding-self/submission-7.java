class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] result = new int[nums.length];
        prefixProduct[0] = 1;
        for(int i = 1; i < nums.length; i++)
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];

        int postfixProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = prefixProduct[i] * postfixProduct;
            postfixProduct *= nums[i]; 
        }

        return result;

    }
}  
