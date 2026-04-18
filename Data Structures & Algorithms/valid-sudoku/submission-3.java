class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> validationSets = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.') {
                if(validationSets.containsKey("r" + i)) {

                    if(validationSets.get("r" + i).contains(board[i][j]))
                        return false;
                    validationSets.get("r" + i).add(board[i][j]);
                } else {    
                    Set<Character> rowSet = new HashSet<>();
                    rowSet.add(board[i][j]);
                    validationSets.put("r" + i, rowSet);
                }

                if(validationSets.containsKey("c" + j)) {
                    if(validationSets.get("c" + j).contains(board[i][j]))
                        return false;
                    validationSets.get("c" + j).add(board[i][j]);
                } else {
                    Set<Character> colSet = new HashSet<>();
                    colSet.add(board[i][j]);
                    validationSets.put("c" + j, colSet);
                }

                if(validationSets.containsKey("rc" + i/3 + j/3)) {
                    if(validationSets.get("rc" + i/3 + j/3).contains(board[i][j]))
                        return false;
                    validationSets.get("rc" + i/3 + j/3).add(board[i][j]);
                } else {

                    Set<Character> subBoardSet = new HashSet<>();
                    subBoardSet.add(board[i][j]);
                    validationSets.put("rc" + i/3 + j/3, subBoardSet);
                }
                }
            }
        }
        return true;
    }
}
