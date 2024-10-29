class Solution {
    public int longestValidParentheses(String s) {
        int count=0;
        ArrayDeque<Integer> h = new ArrayDeque<>();
        h.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                h.push(i);
            }
            else{
                h.pop();
                if(!h.isEmpty()){
                    count=Math.max(count,i-h.peek());
                }
                else{
                    h.push(i);
                }
            }
        }
        return count;
    }
}