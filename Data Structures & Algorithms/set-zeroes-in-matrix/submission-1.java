class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> indexesToBeModified = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    indexesToBeModified.add(new int[] {i, j});
                }
            }
        }

        int[][] directions = {{-1, 0},  {1, 0}, {0, -1}, {0,1}};
        for (int[] index : indexesToBeModified) {
            int row = index[0];
            int col = index[1];
            while(row >= 0) {
                matrix[row][col] = 0;
                row--;
            }

            row = index[0];
            while (row < m) {
                matrix[row][col] = 0;
                row++;
            }

            row = index[0];
            while (col >= 0) {
                matrix[row][col] = 0;
                col--;
            }
            
            col = index[1];
            while (col < n) {
                matrix[row][col] = 0;
                col++;
            }
        }
    }
}
