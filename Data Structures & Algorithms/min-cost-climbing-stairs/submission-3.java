class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
       int[] minCostDFS = new int[n + 1];
       minCostDFS[n] = 0;
       minCostDFS[n - 1] = cost[n - 1];
       for (int i = n - 2; i >= 0; i--) {
            minCostDFS[i] = cost[i] + Math.min(minCostDFS[i + 1], minCostDFS[i + 2]);
       }

       return Math.min(minCostDFS[0], minCostDFS[1]);
    }

    public int minCostClimbingStairs(int[] cost, int idx) {
        if (idx >= cost.length)
            return 0;
        
        return cost[idx] + Math.min(minCostClimbingStairs(cost, idx + 1), minCostClimbingStairs(cost, idx + 2));
    }
}
