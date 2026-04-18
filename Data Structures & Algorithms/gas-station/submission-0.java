class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = arraySum(gas);
        int totalCost = arraySum(cost);
        
        if (totalGas < totalCost) return -1;

        int resultIndex = 0, total = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if(total < 0) {
                total = 0;
                resultIndex = i + 1;
            }
        }

        return resultIndex;
    }

    private int arraySum(int[] arr) {
        int sum = 0;
        for(int num : arr)
            sum += num;
        return sum;
    }
}
