class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> tempStack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!tempStack.isEmpty()) {
                if(temperatures[tempStack.peek()] < temperatures[i]) {
                    result[tempStack.peek()] = i - tempStack.pop();
                } else {
                    break;
                }     
            }

            tempStack.push(i);
        }

        return result;
    }
}
