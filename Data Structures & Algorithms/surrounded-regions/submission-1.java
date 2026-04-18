class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int col = 0; col < cols; col++) {
            modifyBoard(board, 0, col);
            modifyBoard(board, rows - 1, col);
        }

        for (int row = 0; row < rows; row++) {
            modifyBoard(board, row, 0);
            modifyBoard(board, row, cols - 1);
        }

      
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                else if (board[row][col] == 'T')
                    board[row][col] = 'O';
            }
        }


    }

    public void modifyBoard(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
        || board[row][col] != 'O')
            return;
        

        if (board[row][col] == 'O')
            board[row][col] = 'T';

        modifyBoard(board, row + 1, col);
        modifyBoard(board, row - 1, col);
        modifyBoard(board, row, col + 1);
        modifyBoard(board, row, col - 1);

    }

}
