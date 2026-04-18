class Solution {
    public int maxArea(int[] heights) {
       int maxArea = Integer.MIN_VALUE;
       int n = heights.length;
       int start = 0, end = n -1;
       while(start < end) {
        int height = Math.min(heights[start], heights[end]);
        int length = end - start;
        maxArea = Math.max(maxArea, height * length);
        if(heights[start] < heights[end])
            start++;
        else if(heights[start] > heights[end])
            end--;
        else {
            start++;
            end--;
        }
       }

       return maxArea;
    }
}
