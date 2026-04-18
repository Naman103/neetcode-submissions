class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> tempIndexStack = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            while(!tempIndexStack.isEmpty()
            && temperatures[i] > temperatures[tempIndexStack.peek()]) {
                int prevIndex = tempIndexStack.pop();
                result[prevIndex] = i - prevIndex;
            }

            tempIndexStack.push(i);
        }

        return result;
    }
}
