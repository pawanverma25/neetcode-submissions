class MinStack {

    private Stack<Integer> st;
    private TreeMap<Integer, Integer> map;

    public MinStack() {
        st = new Stack<>();
        map = new TreeMap<Integer, Integer>((a, b) -> Integer.compare(a, b));
    }
    
    public void push(int val) {
        st.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int val = st.pop();
        int count = map.get(val);
        if(count == 1) map.remove(val);
        else map.put(val, count - 1);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return map.firstKey();
    }
}
