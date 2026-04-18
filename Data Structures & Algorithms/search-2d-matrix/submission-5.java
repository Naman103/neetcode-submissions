class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0, endRow = matrix.length - 1;
        int midRow = 0;
        while(startRow <= endRow) {
            midRow = (startRow + endRow) / 2;
            if(matrix[midRow][0] == target)
                return true;
            else if (target > matrix[midRow][0]) {
                startRow = midRow + 1;
            } else {
                endRow = midRow - 1;
            }
        }
        
        if(endRow < 0)  return false;
        int startColumn = 0, endColumn = matrix[endRow].length - 1;
        while(startColumn <= endColumn) {
            int midColumn = (startColumn + endColumn)/2;
            if(matrix[endRow][midColumn] == target)
                return true;
            else if(target > matrix[endRow][midColumn])
                startColumn = midColumn + 1;
            else
                endColumn = midColumn - 1;
        } 

        return false;
    }
}
