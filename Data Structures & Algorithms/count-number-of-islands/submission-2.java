class Solution {
    int[][]  directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += traverseIslandGrid(grid, i, j);
            }
        }

        return count;
    }

    public int traverseIslandGrid(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length
        || grid[i][j] != '1')
            return 0;
        
        if(grid[i][j] == '1')
            grid[i][j] = '#';
        
        for (int[] drx : directions)
            traverseIslandGrid(grid, i + drx[0], j + drx[1]);

        return 1;
    }
}
