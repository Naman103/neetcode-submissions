class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        for(String s : tokens) {
            if(!operators.contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int firstValue = stack.pop();
                int secondValue = stack.pop();

                if (s.equals("+")) {
                    stack.push(firstValue + secondValue);
                } else if (s.equals("-")) {
                    stack.push(secondValue - firstValue);
                } else if (s.equals("*")) {
                    stack.push(secondValue * firstValue);
                } else {
                    stack.push(secondValue/firstValue);
                }
            }
        }

        return stack.pop();
    }
}
