class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length, n = matrix[0].length; 

       //Row Find
       int rowStart = 0, rowEnd = m;
       while(rowStart < rowEnd) {
            int rowMid = (rowStart + rowEnd)/2;
            if(matrix[rowMid][0] == target)
                return true;
            else if (matrix[rowMid][0] < target) {
                rowStart = rowMid + 1;
            } else {
                rowEnd = rowMid;
            }
       }

       if(rowEnd <= 0) return false;
       
       int colStart = 0, colEnd = n;
       while(colStart < colEnd) {
        int colMid = (colStart + colEnd)/2;
        if(matrix[rowEnd - 1][colMid] == target)
            return true;
        else if (matrix[rowEnd - 1][colMid] < target) {
            colStart = colMid + 1;
        } else {
            colEnd = colMid;
        }
       }

       return false;
    }

}
