class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i=n-1;
        int carry = 1;
        while(carry>0 && i>=0){
            digits[i]=digits[i]+carry;
            carry=digits[i]/10;
            digits[i]=digits[i]%10;
            i--;
        }
        if(carry>0){
           int ans[] = new int[n+1];
           ans[0]=1; 
           for (int j = 0; j < n; j++) {
                ans[j + 1] = digits[j];
            }
           return ans;
        }
        return digits;
    }
}