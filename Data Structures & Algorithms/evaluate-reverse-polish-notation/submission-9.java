class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String s : tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int first = stack.pop(), second = stack.pop();
                stack.push(second - first);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int first = stack.pop(), second = stack.pop();
                if(first == 0)
                    stack.push(0); 
                else
                    stack.push(second/ first);
            } else {
                stack.push(Integer.parseInt(s));
            }

        }

        return stack.pop();
    }
}
