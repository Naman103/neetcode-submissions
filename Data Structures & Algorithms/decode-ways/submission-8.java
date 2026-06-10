class Solution {
    int result;
    Integer[] dp;
    public int numDecodings(String s) {
        result = 0;
        int n = s.length();
        dp = new Integer[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[0] = 0;
            dp[1] = 0;
        } else {
            dp[0] = 1; 
            dp[1] = 1; 
        }
        numDecoding(s, n);
        return dp[n];
    }

    public int numDecoding(String s, int curIndex) {
        if (dp[curIndex] != null)
            return dp[curIndex];

        dp[curIndex] = 0;
        String oneDigitString = s.substring(curIndex - 1, curIndex);
        Integer oneDigitValue = Integer.parseInt(oneDigitString);
        if (oneDigitValue > 0 && oneDigitValue < 10) {
                dp[curIndex] += numDecoding(s, curIndex - 1);
        }

        if (curIndex > 1) {
            String twoDigitString = s.substring(curIndex - 2, curIndex);
            int twoDigitValue = Integer.parseInt(twoDigitString);
            if (twoDigitValue >= 10 && twoDigitValue <= 26)
                dp[curIndex] += numDecoding(s, curIndex - 2);
        }

        return dp[curIndex];
    }

}
