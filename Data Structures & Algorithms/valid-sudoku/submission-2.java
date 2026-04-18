class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;
        Set<Character> colSet, rowSet, innerSquareSet;
        for(int i = 0; i < 9; i++) {
            colSet = new HashSet<>();
            rowSet = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                char colValue = board[i][j];
                char rowValue = board[j][i];
                if(colValue != '.')
                if(colSet.contains(colValue))
                    return false;
                colSet.add(colValue);
                
                if(rowValue != '.')
                if(rowSet.contains(rowValue))
                return false;
                rowSet.add(rowValue);
            }
        }

        for(int i = 0; i < 9; i++) {
            innerSquareSet = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    int row = (i/3) * 3 + j;
                    int column = (i % 3) * 3  + k;
                    char value = board[row][column];
                    if(value != '.')
                        if(innerSquareSet.contains(value)) 
                            return false;
                    innerSquareSet.add(value);
                }
            }
            System.out.println(" ");
        }

        return true;
    }
}
