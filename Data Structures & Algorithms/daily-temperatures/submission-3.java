class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> tempStack = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            while(!tempStack.isEmpty() && temperatures[i] > temperatures[tempStack.peek()]) {
                int prevIndex = tempStack.pop();
                result[prevIndex] = i - prevIndex;
            }
            tempStack.push(i);
        }

        return result;
    }
}
