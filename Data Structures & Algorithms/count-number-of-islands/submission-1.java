class Solution {
    public int numIslands(char[][] grid) {
        int numIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIsland++;
                    updateVisitedLandPiece(grid, i, j);
                }
            }
        }

        return numIsland;
    }

    private void updateVisitedLandPiece(char[][] grid, int start, int end) {
        if (start < 0 || end < 0 || start >= grid.length || end >= grid[start].length
        || grid[start][end] == '0' || grid[start][end] == '2')
            return;
        grid[start][end] = '2';

        updateVisitedLandPiece(grid, start + 1, end);
        updateVisitedLandPiece(grid, start - 1, end);
        updateVisitedLandPiece(grid, start, end + 1);
        updateVisitedLandPiece(grid, start, end - 1);

    }
}
