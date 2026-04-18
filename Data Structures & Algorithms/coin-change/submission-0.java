class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, coins.length - 1);
    }

    public int helper(int[] coins, int amount, int index) {
        if(amount == 0)
            return 0;
        
        if(amount < 0 || index < 0)
            return -1;

        int includedCoin = helper(coins, amount - coins[index], index);
        int nonIncludedCoin = helper(coins, amount, index - 1);

        if(includedCoin == -1 && nonIncludedCoin == -1)
            return -1;

        if(includedCoin != -1 && nonIncludedCoin != -1)
            return Math.min(1 + includedCoin, nonIncludedCoin);
        
        if(includedCoin != -1)
            return 1 + includedCoin;
        
        if(nonIncludedCoin != -1)
            return nonIncludedCoin;
        
        return -1;
    }
}
