class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        dp[0] = 1;
        if(s.charAt(0) - '0' > 0)
            dp[1] = 1;
        else
            dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if(oneDigit > 0)
                dp[i] += dp[i - 1];
            
            if(twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
        //return decode(s, s.length());
    }

    public int decode(String s, int index) {
        if(index == 0)
            return 1;
        
        if(index == 1 && s.charAt(index - 1) - '0' > 0)
            return 1;
        else if(index == 1)
            return 0;
        
        int oneDigit = Integer.parseInt(s.substring(index - 1, index));
        int twoDigit = Integer.parseInt(s.substring(index - 2, index));
        
        int res = 0;
        if(oneDigit > 0)
            res += decode(s, index - 1);
        
        if(twoDigit >= 10 && twoDigit <= 26)
            res += decode(s, index - 2); 
        
        return res;
    }
}
