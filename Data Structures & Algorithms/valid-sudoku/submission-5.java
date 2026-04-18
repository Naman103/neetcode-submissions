class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> sudokuMap = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    String rowKey = "r" + i;
                    String colKey = "c" + j;
                    String sqKey = "sq" + Integer.valueOf(i)/3  + "," + 
                    Integer.valueOf(j)/3;
                    char value = board[i][j];

                    if(!validSet(rowKey, value, sudokuMap) ||
                    !validSet(colKey, value, sudokuMap) ||
                    !validSet(sqKey, value, sudokuMap)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean validSet(String key, char value, HashMap<String, Set<Character>> sudokuMap) {
        if(sudokuMap.containsKey(key)) {
            if(sudokuMap.get(key).contains(value)) {
                return false;
            } else {
                sudokuMap.get(key).add(value);
                return true;
            }
        } else {
            HashSet<Character> set = new HashSet<>();
            set.add(value);
            sudokuMap.put(key, set);
            return true;
        }
    }
}
