class Solution {
    public int numIslands(char[][] grid) {
       int numIsland = 0;
       for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[i].length; j++) {
            if(grid[i][j] == '1') {
                numIsland++;
                visitCompleteIsland(grid, i, j);
            }
        }

       }

       return numIsland;
    }

    public void visitCompleteIsland(char[][] grid, int i, int j) {
        if(i >= grid.length || i <  0 || j >= grid[i].length || j < 0 || grid[i][j] != '1')
            return;

        grid[i][j] = '2';
        visitCompleteIsland(grid, i + 1, j);
        visitCompleteIsland(grid, i - 1, j);
        visitCompleteIsland(grid, i, j + 1);
        visitCompleteIsland(grid, i, j - 1);
        

    }
}
