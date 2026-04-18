class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(calculateCost(cost, 0), calculateCost(cost, 1));
    }

    public int calculateCost(int[] cost, int index) {
        if(index >= cost.length)
            return 0;
        
        return cost[index] + Math.min(calculateCost(cost, index + 1), calculateCost(cost, index + 2));
    }
}
