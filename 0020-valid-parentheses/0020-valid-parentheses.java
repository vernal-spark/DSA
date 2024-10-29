class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> a=new ArrayDeque<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                a.push(')');
            }
            else if(s.charAt(i)=='['){
                a.push(']');
            }
             else if(s.charAt(i)=='{'){
                a.push('}');
            }
            else if(a.isEmpty() || a.pop()!=s.charAt(i)){
                return false;
            }

        }
        return a.isEmpty();        
    }
}