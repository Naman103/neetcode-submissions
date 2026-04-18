class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minValueStack;
    public MinStack() {
        stack = new Stack<>();
        minValueStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minValueStack.isEmpty())
            minValueStack.push(val);
        else
            minValueStack.push(Math.min(val, minValueStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minValueStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValueStack.peek();
    }
}
