class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> tempStack = new Stack<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            while(!tempStack.isEmpty() && tempStack.peek()[0] < temperatures[i]) {
                int[] temp = tempStack.pop();
                res[temp[1]] = i - temp[1];
            }

            tempStack.push(new int[] {temperatures[i], i});
        }

        return res;
    }
}
