class Solution {
    private int ri(Character c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
    public int romanToInt(String s) {
        int n = s.length(); 
        int ans =0;
        for(int i = 0; i < s.length(); i++){
            if(i<s.length()-1 && ri(s.charAt(i)) < ri(s.charAt(i+1))){
                ans-=ri(s.charAt(i));
            }
            else{
                ans +=ri(s.charAt(i));
            }
        }
        return ans;
    }
}