class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = false;
    }
}
class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode rootNode = this.node;
        for (char c : word.toCharArray()) {
            if (rootNode.children[c - 'a'] == null)
                rootNode.children[c - 'a'] = new TrieNode();
            rootNode = rootNode.children[c - 'a'];
        }

        rootNode.word = true;
    }

    public boolean search(String word) {
        return search(word, 0, this.node);
    }

    private boolean search(String word, int index, TrieNode root) {
        TrieNode currentNode = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : currentNode.children) {
                    if (child != null && search(word, i + 1, child))
                        return true;
                }
                return false;
            } else {
                TrieNode[] childs = currentNode.children;
                if (childs[c - 'a'] == null)
                    return false;
                
                currentNode = childs[c - 'a'];
            }
        }
        
        return currentNode.word;
    }
}
