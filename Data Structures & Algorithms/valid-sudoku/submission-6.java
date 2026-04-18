class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> sudokuMap = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String rowKey = "r" + i;
                    String colKey = "c" + j;
                    String sqKey = "r" + i/3 + j/3;
                    if(!validSet(sudokuMap, rowKey, board[i][j])
                    || !validSet(sudokuMap, colKey, board[i][j])
                    || !validSet(sudokuMap, sqKey, board[i][j]))
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean validSet(HashMap<String, Set<Character>> sudokuMap, String key, char cellValue) {
        if(sudokuMap.containsKey(key)) {
            if(sudokuMap.get(key).contains(cellValue))
                return false;
            
            sudokuMap.get(key).add(cellValue);
        } else {
            Set<Character> charSet = new HashSet<>();
            charSet.add(cellValue);
            sudokuMap.put(key, charSet);
        }

        return true;
    }
}
