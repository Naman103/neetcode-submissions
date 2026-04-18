class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottingOrangeQueue = new LinkedList<>();
        int freshCount = 0;
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            int m = grid[i].length;
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2)
                    rottingOrangeQueue.offer(new int[] {i, j});
                else if(grid[i][j] == 1)
                    freshCount++;
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int minute = 0;
        while(!rottingOrangeQueue.isEmpty()) {

            boolean rottenInThisMinute = false;
            int size = rottingOrangeQueue.size();
            for(int i = 0; i < size; i++) {
            int[] currentRotIndex = rottingOrangeQueue.poll();
            int row = currentRotIndex[0], col = currentRotIndex[1];

            for(int[] dx : directions) {
                int r = row + dx[0], c = col + dx[1];
                if(r < 0 || r >= n || c < 0 || c >= grid[r].length || grid[r][c] != 1)
                    continue;
                
                grid[r][c] = 2;
                freshCount--;
                rottingOrangeQueue.offer(new int[] {r, c});
                rottenInThisMinute = true;
            }

            }
            
            if(rottenInThisMinute) {
                printGrid(grid);
                minute++; 
             }
        }
    
        return freshCount == 0 ? minute : -1;
    }

    public void printGrid(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}
