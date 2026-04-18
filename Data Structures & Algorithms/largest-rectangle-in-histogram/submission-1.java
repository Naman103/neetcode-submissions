class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            int width = 1;
            while(left >= 0 && heights[left] >= heights[i]) {
                left--;
                width++;
            }

            while(right < n && heights[right] >= heights[i]) {
                right++;
                width++;
            }

            maxArea = Math.max(heights[i] * width, maxArea);
        }

        return maxArea;
    }
}
