class Trie {
    char c;
    boolean endOfWord;
    Map<Character, Trie> trieMap;

    public Trie() {
        this.c = ' ';
        this.endOfWord = false;
        this.trieMap = new HashMap<>();
    }

    public Trie(char c) {
        this.c = c;
        this.endOfWord = false;
        this.trieMap = new HashMap<>();
    }

    public void addWord(String word) {
        Trie currentHead = this;
        for (Character c : word.toCharArray()) {
            if (!currentHead.trieMap.containsKey(c))
                currentHead.trieMap.put(c, new Trie(c));
            currentHead = currentHead.trieMap.get(c);
        }

        currentHead.endOfWord = true;
    }
}
class Solution {
    List<String> result;
    Set<String> visitedSet;
    int[][] directions = {{-1, 0},  {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie headNode = new Trie();
        for (String word : words)
            headNode.addWord(word);
        
        result = new ArrayList<>();
        visitedSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(headNode.trieMap.containsKey(board[i][j]))
                    dfs(board, i, j, headNode, "");
            }
        }

        return result;

    }

    public void dfs(char[][] board, int row, int col, Trie headNode, String word) {
        String setKey = row + ":" + col;
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || visitedSet.contains(setKey) )
            return;
        
        if(!headNode.trieMap.containsKey(board[row][col])) {   
            return;
        }
        
        visitedSet.add(setKey);
        headNode = headNode.trieMap.get(board[row][col]);
        word += board[row][col];

        if (headNode.endOfWord && !result.contains(word))
            result.add(word);

        for (int[] drx : directions) {
            int nr = row + drx[0];
            int nc = col + drx[1];
            dfs(board, nr, nc, headNode, word);
        }

        visitedSet.remove(setKey);

    }
}
