class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, Set<Character>> validationSets = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.') {
                if(!isValidRowColumnTable("r" + i, board[i][j], validationSets)
                || !isValidRowColumnTable("c" + j, board[i][j], validationSets)
                || !isValidRowColumnTable("rc" + i/3 + j/3, board[i][j], validationSets))
                return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRowColumnTable(String startKey, char gridChar, HashMap<String, Set<Character>> mapSet) {
        if(mapSet.containsKey(startKey)) {
            if(mapSet.get(startKey).contains(gridChar))
                return false;
            mapSet.get(startKey).add(gridChar);
        } else {
            Set<Character> subSet = new HashSet<>();
            subSet.add(gridChar);
            mapSet.put(startKey, subSet);
        }

        return true;
    }
}
