class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0, rowEnd = matrix.length;
        while(rowStart < rowEnd) {
            int midRow = (rowStart + rowEnd)/2;
            if(matrix[midRow][0] == target)
                return true;
            else if (matrix[midRow][0] < target)
                rowStart = midRow + 1;
            else
                rowEnd = midRow;
        }

        if (rowEnd <= 0)    return false;

        int colStart = 0, colEnd = matrix[0].length;
        while(colStart < colEnd) {
            int colMid = (colStart + colEnd)/2;
            if(matrix[rowEnd - 1][colMid] == target)
                return true;
            else if (matrix[rowEnd - 1][colMid] < target)
                colStart = colMid + 1;
            else
                colEnd = colMid;
        }

        return false;
    }
}
