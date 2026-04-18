class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    area = Math.max(area, gridArea(grid, i, j));
            }
        }

        return area;
    }

    private int gridArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
        || grid[row][col] != 1)
            return 0;
        
        int gridArea = grid[row][col];
        grid[row][col] = 0;
        return gridArea
         + gridArea(grid, row - 1, col)
         + gridArea(grid, row + 1, col)
         + gridArea(grid, row, col - 1)
         + gridArea(grid, row, col + 1);

    }
}
