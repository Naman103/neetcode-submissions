class TrieNode {
    char character;
    boolean isEndofWord;
    TrieNode[] nextNode;

    public TrieNode() {
        this.character = ' ';
        this.isEndofWord = false;
        this.nextNode = new TrieNode[26];
    }

    public TrieNode(char c) {
        this.character = c;
        this.isEndofWord = false;
        this.nextNode = new TrieNode[26];
    }
}

class PrefixTree {

    TrieNode trieNode;
    public PrefixTree() {
         trieNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode root = trieNode;
        for (char c : word.toCharArray()) {
            TrieNode[] currentList = root.nextNode;
            if (currentList[c - 'a'] == null) {
                currentList[c - 'a'] =  new TrieNode(c);
            }

            root = currentList[c - 'a'];
        }

        root.isEndofWord = true;
    }

    public boolean search(String word) {
        TrieNode root = trieNode;
        for (char c : word.toCharArray()) {
            TrieNode[] currentList = root.nextNode;
            if (currentList[c - 'a'] == null)
                return false;
            root = currentList[c - 'a'];
        }

        return root.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode root = trieNode;
        for (char c : prefix.toCharArray()) {
            TrieNode[] currentList = root.nextNode;
            if (currentList[c - 'a'] == null)
                return false;
            root = currentList[c - 'a'];
        }

        return true;
    }
}
