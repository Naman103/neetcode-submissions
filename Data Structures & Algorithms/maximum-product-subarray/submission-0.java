class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int product = nums[i];
            maxProduct = Math.max(product, maxProduct);
            for(int j = i + 1; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }

        return maxProduct;
    }

}
