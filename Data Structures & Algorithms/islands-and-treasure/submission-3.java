class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> treasureQueue = new LinkedList<>();
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0)
                    treasureQueue.offer(new int[] {i, j});
            }
        }
        int m = grid.length;
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!treasureQueue.isEmpty()) {
            int[] position = treasureQueue.poll();
            int row = position[0], col = position[1];
            int n = grid[row].length;
            for(int[] d : directions) {
                int r = row + d[0];
                int c = col + d[1];
                if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != Integer.MAX_VALUE)
                    continue;
                
                grid[r][c] = 1 + grid[row][col];
                treasureQueue.offer(new int[] {r, c} );
            }

        }
    }
}
