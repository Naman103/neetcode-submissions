class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        reverseRows(matrix, n);
    }

    private void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && i < j) {
                    swap(matrix, i, j);
                }
            }
        }
    }

    private void reverseRows(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - j - 1];
                arr[i][n - j - 1] = temp; 
            }
        }
    }

    private void swap (int[][] arr, int row, int column) {
        int temp = arr[row][column];
        arr[row][column] = arr[column][row];
        arr[column][row] = temp;
    }


}
