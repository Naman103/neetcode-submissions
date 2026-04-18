class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n], suffix = new int[n];
        int maxValue = 0;
        for(int i = 0; i < n; i++) {
            if(height[i] > maxValue)
                maxValue = height[i];
            prefix[i] = maxValue;
        }

        maxValue = 0;
        for(int i = n - 1; i >=0 ; i--) {
            if(height[i] > maxValue)
                maxValue = height[i];
            suffix[i] = maxValue;
        }

        int area = 0;
        for(int i = 0; i < n; i++)
            area += Math.min(prefix[i], suffix[i]) - height[i];

        return area; 
    }
}
