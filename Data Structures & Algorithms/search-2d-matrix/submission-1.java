class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0, rowEnd = matrix.length - 1;
        while(rowStart <= rowEnd) {
            int rowMid = (int) Math.floor((rowStart + rowEnd) / 2);
            if(matrix[rowMid][0] == target) {
                return true;
            } else if (target > matrix[rowMid][0]) {
                rowStart = rowMid + 1;
            } else {
                rowEnd = rowMid - 1;
            }
        }

        if(rowEnd < 0) return false;
        int[] columnArray = matrix[rowEnd];
        int colStart = 0, colEnd = columnArray.length - 1;
        while(colStart <= colEnd) {
            int colMid = (int) Math.floor((colStart + colEnd) /2 );
            if(columnArray[colMid] == target)
                return true;
            else if (target > columnArray[colMid])
                colStart = colMid + 1;
            else
                colEnd = colMid - 1;
        }

        return false;
    }
}
