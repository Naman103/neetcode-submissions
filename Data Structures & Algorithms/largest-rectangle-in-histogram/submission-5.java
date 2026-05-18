class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftArea = new int[n];
        int[] rightArea = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftArea[i] = -1;
             while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                leftArea[i] = stack.peek();
            
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            rightArea[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            
            if (!stack.isEmpty())
                rightArea[i] = stack.peek();
            
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            leftArea[i] += 1;
            rightArea[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightArea[i] - leftArea[i] + 1));
        }

        return maxArea; 
    }
}
