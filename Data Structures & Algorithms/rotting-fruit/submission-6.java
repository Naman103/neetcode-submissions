class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> rottenFruitQueue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    rottenFruitQueue.offer(new int[] {i, j});
            }
        }

        int timeTaken = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!rottenFruitQueue.isEmpty()) {
            int size = rottenFruitQueue.size();
            boolean processed = false;
            for (int i = 0; i < size; i++) {
            int[] rottenFruitPos = rottenFruitQueue.poll();
            
            for (int[] drx : directions) {
                int row = rottenFruitPos[0], col = rottenFruitPos[1];
                int r = row + drx[0], c = col + drx[1];
                if (r < 0 || c < 0 || r >= grid.length 
                || c >= grid[r].length || grid[r][c] != 1)
                continue;

                processed = true;
                grid[r][c] = 2;
                rottenFruitQueue.offer(new int[] {r, c});
            }
            }

            if (processed)
                timeTaken++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    return -1;
        }

        return timeTaken;
    }
}
