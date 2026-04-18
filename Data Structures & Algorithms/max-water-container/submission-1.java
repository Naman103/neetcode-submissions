class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0, end = heights.length - 1;
        while(start < end) {
            int effectiveHeight = Math.min(heights[start], heights[end]);
            int effectiveWidth = end - start;

            System.out.println("Height : " + effectiveHeight + " Width : " + effectiveWidth);
            maxArea = Math.max(effectiveWidth * effectiveHeight, maxArea);

            if(heights[start] > heights[end])
                end--;
            else if(heights[start] < heights[end])
                start++;
            else {
                start++;
                end--;
            }
        }

        return maxArea;
    }   
}
