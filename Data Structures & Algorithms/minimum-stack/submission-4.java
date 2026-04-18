class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
       stack = new Stack<>();
       minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val < minStack.peek())
            minStack.push(val);
        else
            minStack.push(minStack.peek());
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return 0;
        return minStack.peek();
    }
}
