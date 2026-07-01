class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        //int res = lcs(text1, text2, m - 1, n - 1, 0);
        return dp[m][n];
    }

    private int lcs(String x, String y, int ix, int iy, int len) {
        if (ix < 0 || iy < 0) {
            return len;
        }

        if (x.charAt(ix) == y.charAt(iy)) {
            len = lcs(x, y, ix - 1, iy - 1, len + 1);
        } else {
            len = Math.max(len, Math.max(lcs(x, y, ix - 1, iy, len), lcs(x, y, ix, iy - 1, len)));
        }

        return len;
            
    }
}
