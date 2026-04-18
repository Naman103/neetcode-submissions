class Solution {
    public int maxProfit(int[] prices) {
        int costPrice = prices[0], maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > costPrice) {
                maxProfit = Math.max(prices[i] - costPrice, maxProfit);
            } else {
                costPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
