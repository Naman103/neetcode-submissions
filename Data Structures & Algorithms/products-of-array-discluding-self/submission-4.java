class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n = nums.length;
     int[] prefixProduct = new int[n], postfixProduct = new int[n];
     Arrays.fill(prefixProduct, 1);
     Arrays.fill(postfixProduct, 1);
     for(int i = 1; i < n; i++)
        prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
    
    for(int i = n - 2; i >= 0; i--) 
        postfixProduct[i] = nums[i + 1] * postfixProduct[i + 1];
    
    int[] res = new int[n];
    for(int i = 0;  i < n; i++) {
        res[i] = prefixProduct[i] * postfixProduct[i];
    }

    return res;
    }
}  
