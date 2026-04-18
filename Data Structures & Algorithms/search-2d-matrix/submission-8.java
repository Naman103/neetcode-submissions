class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLeft = 0, rowRight = matrix.length;
        
        while(rowLeft < rowRight) {
            int rowMid = (rowLeft + rowRight) / 2;
            if(matrix[rowMid][0] == target)
                return true;
            else if (target > matrix[rowMid][0])
                rowLeft = rowMid + 1;
            else
                rowRight = rowMid;
        }

        if(rowRight <= 0) return false; 

        int colLeft = 0, colRight = matrix[rowRight - 1].length;
        while(colLeft < colRight) {
            int colMid = (colLeft + colRight)/2;
            if(target == matrix[rowRight - 1][colMid])
                return true;
            else if (target > matrix[rowRight - 1][colMid])
                colLeft = colMid + 1;
            else
                colRight = colMid;
        }

        return false;
    }
}
