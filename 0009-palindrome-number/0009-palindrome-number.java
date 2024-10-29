class Solution {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        int s=0,l=str.length()-1;
        while(s<l){
            if(str.charAt(s)!=str.charAt(l)){
                return false;
            }
            else{
                s++;
                l--;
            }
        }
        return true;
    }
}