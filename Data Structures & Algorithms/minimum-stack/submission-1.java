class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minStack;


    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
