class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int l1=nums1.length;
        int l2=nums2.length;
        int l=0,h=l1,mergedArrayMid=(l1+l2+1)/2;
        while(l<=h){
            int mid=(l+h)/2;
            int leftAsize=mid;
            int leftBsize=mergedArrayMid-mid;
            int leftA=leftAsize>0?nums1[leftAsize-1]:Integer.MIN_VALUE;
            int leftB=leftBsize>0?nums2[leftBsize-1]:Integer.MIN_VALUE;
            int rightA=leftAsize<l1?nums1[leftAsize]:Integer.MAX_VALUE;
            int rightB=leftBsize<l2?nums2[leftBsize]:Integer.MAX_VALUE;
            if(leftA<=rightB && leftB<=rightA){
                if((l1+l2)%2==0){
                    return (double)(Math.max(leftA,leftB)+Math.min(rightA,rightB))/2;
                }
                return Math.max(leftA,leftB);
            }
            else if(leftA>rightB){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return 0;
    }
}