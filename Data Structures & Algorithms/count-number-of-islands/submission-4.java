class Solution {
    int[][] directions = {{-1, 0},  {1, 0} , {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] drx : directions) {
                int r = point[0] + drx[0], c = point[1] + drx[1];
                if (r >= 0 && c >= 0 && r < grid.length && c < grid[r].length
                && grid[r][c] == '1') {
                    queue.offer(new int[]{r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }
}
