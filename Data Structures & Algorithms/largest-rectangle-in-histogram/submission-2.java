class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            int width = 1;
            while(left >= 0 && heights[left] >= heights[i]) {
                width++;
                left--;
            }
            
            while(right < n && heights[right] >= heights[i]) {
                width++;
                right++;
            }
            
            maxArea = Math.max(maxArea, width * heights[i]);
        }

        return maxArea;
    }
}
