class Solution {
    public int[] productExceptSelf(int[] nums) {
       long totalProduct = 1;
       int zeroCount = 0;
       for(int num : nums) {
            if(num == 0)
                zeroCount++;
            else
                totalProduct *= num; 
       }

        int[] productArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(zeroCount >= 2)
                productArray[i] = 0;
            else if(zeroCount > 0) {
                if(nums[i] != 0)
                    productArray[i] = 0;
                else
                    productArray[i] = (int) totalProduct;
            } else {
            productArray[i] = (int) (totalProduct/nums[i]);
            }
        }

        return productArray;
    }
}  
