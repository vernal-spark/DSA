class Solution {
    
    public int[] countBits(int n) {
        int a[] = new int[n+1];
        a[0]=0;
        for(int i=1;i<=n;i++){
            a[i]=(i&1)+a[i/2];
        }
        return a;
    }
}