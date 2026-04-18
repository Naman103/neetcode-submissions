class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                if (wordMatches(board, i, j, 0, word))
                    return true;
        }

        return false;
    }

    public boolean wordMatches(char[][] board, int x, int y, int wordIdx, String word) {
        if (wordIdx >= word.length())
            return true;
        
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != word.charAt(wordIdx))
            return false;
        
        char c = board[x][y];
        board[x][y] = '#';

        boolean res = 
        wordMatches(board, x + 1, y, wordIdx + 1, word)
        || wordMatches(board, x, y + 1, wordIdx + 1, word)
        || wordMatches(board, x - 1, y , wordIdx + 1, word)
        || wordMatches(board, x, y - 1, wordIdx + 1, word);

        board[x][y] = c;

        return res;
    }


}
