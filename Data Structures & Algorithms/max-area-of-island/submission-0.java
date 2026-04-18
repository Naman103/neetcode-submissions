class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                maxArea = Math.max(maxArea, getAreaOfIsland(grid, i, j));

        return maxArea;
    }

    public int getAreaOfIsland(int[][] grid, int i , int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1)
            return 0;
        
        int area = grid[i][j];
        grid[i][j] = 2;
        return area + getAreaOfIsland(grid, i + 1, j) + getAreaOfIsland(grid, i - 1, j) + getAreaOfIsland(grid, i, j + 1) + getAreaOfIsland(grid, i, j - 1); 
    }
}
