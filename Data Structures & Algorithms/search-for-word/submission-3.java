class Solution {
    
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = prepareVisitedArray(board);
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(matchWord(board, i, j, word, 0, isVisited))
                    return true;
            }
        }

        return false;
    }

    public boolean[][] prepareVisitedArray(char[][] board) {
        boolean[][] isVisited = new boolean[board.length][];
        for(int row = 0; row < board.length; row++) {
            isVisited[row] = new boolean[board[0].length];
        }

        return isVisited;
    }

    public boolean matchWord(char[][] board, int row, int column, String word, int wordCharPos, boolean[][] isVisited) {
        if(wordCharPos >= word.length())
            return true;
    
        if(!isValidRowColumn(board, row, column) || board[row][column] != word.charAt(wordCharPos) || isVisited[row][column])
            return false;
        
        isVisited[row][column] = true;
        boolean res =  matchWord(board, row - 1, column, word, wordCharPos + 1, isVisited) || matchWord(board, row + 1, column, word, wordCharPos + 1, isVisited)
        || matchWord(board, row, column - 1, word, wordCharPos + 1, isVisited)
        || matchWord(board, row, column + 1, word, wordCharPos + 1, isVisited);
        
        isVisited[row][column] = false;

        return res;

    }

    public boolean isValidRowColumn(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return false;

        return true;
    }
}
