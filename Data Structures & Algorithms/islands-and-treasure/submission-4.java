class Solution {

    public void islandsAndTreasure(int[][] grid) {
        LinkedList<int[]> treasurePosQueue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 0)
                    treasurePosQueue.offer(new int[] {i, j});
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!treasurePosQueue.isEmpty()) {
            int[] treasurePos = treasurePosQueue.poll();
            int row = treasurePos[0], col = treasurePos[1];
            for (int[] drx : directions) {
                int r = row + drx[0], c = col + drx[1];
                if (r < 0 || c < 0 || r >= grid.length
                 || c >= grid[r].length || grid[r][c] != Integer.MAX_VALUE)
                continue;

                grid[r][c] = 1 + grid[row][col];
                treasurePosQueue.offer(new int[] {r, c});
            }
        }
    }
}
