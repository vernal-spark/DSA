import java.util.Stack;

class MinStack {
    private Stack<Long> s;
    private long minEle;

    public MinStack() {
        this.s = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long) val; 
        if (s.isEmpty()) {
            s.push(value);
            minEle = value;
        } else {
            if (value >= minEle) {
                s.push(value);
            } else {
                s.push(2 * value - minEle); 
                minEle = value;
            }
        }
    }
    
    public void pop() {
        if (s.isEmpty()) return;
        
        long t = s.pop();
        if (t < minEle) {
            minEle = 2 * minEle - t; 
        }
    }
    
    public int top() {
        if (s.isEmpty()) return -1;

        long t = s.peek();
        if (t < minEle) {
            return (int) minEle; 
        } else {
            return (int) t;
        }
    }
    
    public int getMin() {
        if (s.isEmpty()) return -1; 
        return (int) minEle;
    }
}
