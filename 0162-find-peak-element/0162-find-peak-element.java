class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return -1;
    }
}