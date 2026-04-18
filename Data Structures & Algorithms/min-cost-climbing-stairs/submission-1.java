class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //return Math.min(calculateCost(cost, 0), calculateCost(cost, 1));
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n-1];
        for(int i = n - 2; i >= 0; i--)
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        
        return Math.min(dp[0], dp[1]);

    }

    // public int calculateCost(int[] cost, int index) {
    //     if(index >= cost.length)
    //         return 0;
        
    //     return cost[index] + Math.min(calculateCost(cost, index + 1), calculateCost(cost, index + 2));
    // }
}
