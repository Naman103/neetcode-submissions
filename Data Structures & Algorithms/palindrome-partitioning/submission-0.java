class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);
        return res;
    }

    public void dfs(int pos, String s, List<String> part, List<List<String>> res) {
        if(pos >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j = pos; j < s.length(); j++) {
            if(isPallindrome(s, pos, j)) {
                part.add(s.substring(pos, j + 1));
                dfs(j + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }
        
    }

    public boolean isPallindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
