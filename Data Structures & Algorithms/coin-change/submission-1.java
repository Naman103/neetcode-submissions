class Solution {
    
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, coins.length - 1);  
    }

    public int coinChange(int[] coins, int amount, int coinIndex) {
        if (amount == 0)
            return 0;

        if (amount < 0 || coinIndex < 0)
            return -1;
    
        
        int includedResult = coinChange(coins, amount - coins[coinIndex], coinIndex);
        int excludedResult = coinChange(coins, amount, coinIndex - 1);
        

        if (includedResult == -1 && excludedResult == -1)
            return -1;
        
        if (includedResult != -1 && excludedResult != -1)
            return Math.min(1 + includedResult, excludedResult);
        
        if (includedResult == -1)
            return excludedResult;
        
        if (excludedResult == -1)
            return 1 + includedResult;
        
        return -1;
    }
}
