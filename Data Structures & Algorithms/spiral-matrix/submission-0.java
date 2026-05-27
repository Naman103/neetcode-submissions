class Solution {
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = 0;
        int size = m * n;
        int sRow = 0, eRow = n, sCol = 0, eCol = m;
        while(result.size() < size) {
            System.out.println(row +  " : " + col);
            while (col < eCol && result.size() < size) {
                result.add(matrix[row][col]);
                col++;
            }
            col--;
            row++;


            System.out.println(row +  " : " + col);
            while (row < eRow && result.size() < size) {
                result.add(matrix[row][col]);
                row++;
            }
            row--;
            col--;

            System.out.println(row +  " : " + col);
            while (col >= sCol && result.size() < size) {
                result.add(matrix[row][col]);
                col--;
            }
            col++;
            row--;

            System.out.println(row +  " : " + col);
            while (row > sRow && result.size() < size) {
                result.add(matrix[row][col]);
                row--;
            }
            row++;
            col++;

            sRow++;
            eRow--;
            sCol++;
            eCol--;
        }

        return result;
    }
}
