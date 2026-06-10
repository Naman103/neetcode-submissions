class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[amount + 1][n + 1];

        //Initialization
        for (int i = 0; i <= amount; i++)
            dp[i][0] = -1;
        
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                int inCoin = -1;
                if (i >= coins[j - 1])
                    inCoin = dp[i - coins[j - 1]][j];
                int exCoin = dp[i][j - 1];
                if (inCoin == -1 && exCoin == -1) {
                    dp[i][j] = -1;
                } else if (inCoin != -1 && exCoin != -1) {
                    dp[i][j] = Math.min(1 + inCoin, exCoin);
                } else if (inCoin == -1) {
                    dp[i][j] = exCoin;
                } else {
                    dp[i][j] = 1 + inCoin;
                }
            }
        }

        //return coinChange(coins, amount, n); 
        // for(int i = 0; i <= amount; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         if (dp[i][j] != null)
        //             System.out.print(dp[i][j] + " ");
        //         else
        //             System.out.print("-2 ");
        //     }

        //     System.out.println();
        // }
        return dp[amount][n]; 
    }

    public int coinChange(int[] coins, int amount, int coinIndex) {
        if (amount == 0) {
            dp[amount][coinIndex] = 0;
            return 0;
        }

        if (amount < 0 || coinIndex <= 0) {
            return -1;
        }

        if (dp[amount][coinIndex] != null)
            return dp[amount][coinIndex];
    
    
        int includedResult = coinChange(coins, amount - coins[coinIndex - 1], coinIndex);
        int excludedResult = coinChange(coins, amount, coinIndex - 1);
        
        if (includedResult == -1 && excludedResult == -1) {
            dp[amount][coinIndex] = -1;
        } else if (includedResult != -1 && excludedResult != -1) {
            dp[amount][coinIndex] = Math.min(1 + includedResult, excludedResult);
        } else if (includedResult == -1) {
            dp[amount][coinIndex] = excludedResult;
        } else if (excludedResult == -1) {
            dp[amount][coinIndex] = 1 + includedResult;
        }
        
        return dp[amount][coinIndex];
    }
}
