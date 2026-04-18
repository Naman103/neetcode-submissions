class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = prices[0], maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minBuyPrice;
            maxProfit = Math.max(profit, maxProfit);

            minBuyPrice = Math.min(prices[i], minBuyPrice);
        }

        return maxProfit;
    }
}
