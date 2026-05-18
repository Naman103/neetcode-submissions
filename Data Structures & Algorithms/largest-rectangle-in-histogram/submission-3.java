class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftArea = new int[n];
        int[] rightArea = new int[n];
        int maxArea = 0;
        for (int curBarIndex = 0; curBarIndex < n; curBarIndex++) {
            int i = curBarIndex - 1;
            int width = 1;
            while (i >= 0 && heights[i] >= heights[curBarIndex]) {
                width++;
                i--;
            }

            i = curBarIndex + 1;
            while (i < n && heights[i] >= heights[curBarIndex]) {
                width++;
                i++;
            }

            maxArea = Math.max(width * heights[curBarIndex], maxArea);

        }

        return maxArea; 
    }
}
