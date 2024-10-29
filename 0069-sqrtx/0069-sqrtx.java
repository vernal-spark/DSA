class Solution {
    public int mySqrt(int x) {
        int l=1,h=x,mid=-1;
        while(l<=h){
            mid=l+(h-l)/2;
            if((long)mid*mid==(long) x){
                return mid;
            }
            else if((long) mid*mid<(long)x){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return Math.round(h);
    }
}