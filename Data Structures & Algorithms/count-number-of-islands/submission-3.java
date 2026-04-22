class Solution {
    int[][] directions = {{-1, 0},  {1, 0} , {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
        || grid[row][col] != '1')
            return;
        
        grid[row][col] = '0';

        for (int[] drx : directions)
            dfs(grid, row + drx[0], col + drx[1]);
    }
}
