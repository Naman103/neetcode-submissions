class Solution {
    Integer[] result = new Integer[101];
    public int minCostClimbingStairs(int[] cost) {
        result[0] = cost[0];
        result[1] = cost[1];
        return Math.min(minCostClimbingStairs(cost, cost.length - 1),minCostClimbingStairs(cost, cost.length - 2));
    }

    public int minCostClimbingStairs(int[] cost, int index) {
        if (result[index] != null)
            return result[index];

        
        result[index] = cost[index] + Math.min(minCostClimbingStairs(cost, index - 1),
        minCostClimbingStairs(cost, index - 2));
        return result[index];
    }   
}
