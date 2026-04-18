class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0, end = heights.length - 1;
        while(start < end) {
            int height = Math.min(heights[start], heights[end]);
            int width = end - start;
            maxArea = Math.max(maxArea, height * width);

            if(heights[start] < heights[end])
                start++;
            else
                end--;
        }

        return maxArea;
    }
}
