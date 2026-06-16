class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i] = dp[i + word.length()];
                    if (dp[i] != null && dp[i])
                        break;
                }
            }
        }

        return dp[0] != null ? dp[0] : false;
        //return wordBreak(s, 0, wordDict);
    }

    public boolean wordBreak(String s, int index, List<String> wordDict) {
        if (index > s.length()) 
            return false;

        if (dp[index] != null)
            return dp[index];

        if (index == s.length()) {
            dp[index] = true;
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, index) && wordBreak(s, index + word.length(), wordDict)) {
                dp[index] = true;
                return true;
            }
        }

        dp[index] = false;
        return false;
    }
}
