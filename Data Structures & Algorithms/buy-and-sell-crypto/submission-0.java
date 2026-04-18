class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int buyPriceIndex = 0, sellPriceIndex = 1, maxProfit = 0;
        while(buyPriceIndex < sellPriceIndex && sellPriceIndex < prices.length) {
            int profit = prices[sellPriceIndex] - prices[buyPriceIndex];
            if(prices[sellPriceIndex] < prices[buyPriceIndex])
                buyPriceIndex = sellPriceIndex;
            sellPriceIndex++;
            maxProfit = Math.max(profit, maxProfit); 
        }

        return maxProfit;
    }
}
