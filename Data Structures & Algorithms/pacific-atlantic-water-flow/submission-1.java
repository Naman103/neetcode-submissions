class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1,0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacificOcean = new boolean[rows][cols];
        boolean[][] atlanticOcean = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacificOcean);
            dfs(heights, rows - 1, c, Integer.MIN_VALUE, atlanticOcean);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, r , 0, Integer.MIN_VALUE, pacificOcean);
            dfs(heights, r, cols - 1, Integer.MIN_VALUE, atlanticOcean);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificOcean[i][j] && atlanticOcean[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] oceanArray) {
        if (row < 0 || col < 0 || row >= heights.length ||
        col >= heights[row].length || heights[row][col] < prevHeight
        || oceanArray[row][col])
            return;
        
        oceanArray[row][col] = true;

        for (int[] drx : directions) {
            int r = row + drx[0], c = col + drx[1];
            dfs(heights, r, c, heights[row][col], oceanArray);
        }

    }
}
