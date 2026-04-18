class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, width = 1, n = heights.length;
        for(int i = 0; i < n; i++) {
            width = 0;
            int j = i - 1;
            while(j >= 0 && heights[j] >= heights[i]) {
                width++;
                j--;
            }
            System.out.print("Left Area from  " + i + " : " + width * heights[i]);
            int leftArea = heights[i] * width;
            maxArea = Math.max(maxArea, width * heights[i]);

            j = i + 1;
            width = 1;
            while(j < n && heights[j] >= heights[i]) {
                width++;
                j++;
            }
            System.out.print(" | Right Area from  " + i + " : " + width * heights[i]);
            int rightArea = heights[i] * width;
            maxArea = Math.max(maxArea, leftArea + rightArea);
            System.out.println();
        }

        return maxArea;
    }

}
