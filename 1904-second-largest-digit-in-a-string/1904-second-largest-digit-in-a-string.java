class Solution {
    public int secondHighest(String s) {
        int max=-1,smax=-1;
        for(int k=0;k<s.length();k++){
            Character c = s.charAt(k);
            if(c>=48 && c<=57){
                int i = (int)c-48;
                if(i>max){
                    smax=max;
                    max=i;
                }
                else if(i<max && i>smax){
                    smax = i;
                }
            }
        }
        return smax;
    }
}