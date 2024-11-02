class StockSpanner {
    ArrayList<Integer> arr;
    Stack<Integer> s;
    int count;
    public StockSpanner() {
        arr = new ArrayList<>();
        s = new Stack<>();
        count = -1;
    }
    
    public int next(int price) {
        count++;
        arr.add(price);
        while(!s.isEmpty() && arr.get(s.peek())<=price){
            s.pop();
        }
        int ans = s.isEmpty()?count+1:count-s.peek();
        s.push(count);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */