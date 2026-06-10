class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.charAt(0) != '0') {
            dp[0] = 1; 
            dp[1] = 1; 
        }

        for (int i = 2; i <= n; i++) {
            int oneDigitValue = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigitValue > 0)
                dp[i] += dp[i - 1];
            
            int twoDigitValue = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigitValue >= 10 && twoDigitValue <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }

}
