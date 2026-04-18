class Solution {
    private Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return helperMethod(s, 0, wordDict);
    }

    public boolean helperMethod(String s, int index, List<String> wordDict) {
        if (memo.containsKey(index))
            return memo.get(index);
        
        for(String w : wordDict) {
            if (index + w.length() <= s.length() &&
            s.substring(index, index + w.length()).equals(w)) {
                if (helperMethod(s, index + w.length(), wordDict)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false);
        return false;
    }
}
