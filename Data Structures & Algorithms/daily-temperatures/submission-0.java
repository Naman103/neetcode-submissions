class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] tempResult = stack.pop();
                result[tempResult[0]] = i - tempResult[0];
            }
            stack.push(new int[] {i, temperatures[i]});
        }
        return result;
    }
}
