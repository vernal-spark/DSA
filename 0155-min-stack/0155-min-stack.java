class MinStack {
    private ArrayList<Integer> s;
    private ArrayList<Integer> minStack;

    public MinStack() {
        this.s = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        s.add(val);
        if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
            minStack.add(val);
        }
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        int removed = s.remove(s.size() - 1);
        if (removed == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }
    
    public int top() {
        if (s.isEmpty()) return -1;
        return s.get(s.size() - 1);
    }
    
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.get(minStack.size() - 1);
    }
}