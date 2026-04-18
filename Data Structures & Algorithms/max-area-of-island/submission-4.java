class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, calculateArea(grid, i, j));
            }
        }

        return maxArea;
    }

    public int calculateArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
        || grid[row][col] != 1)
            return 0;
        
        int area = grid[row][col];
        grid[row][col] = 0;
        for (int[] drx : directions) {
            area += calculateArea(grid, row +drx[0], col + drx[1]);
        }

        return area;
    }


}
