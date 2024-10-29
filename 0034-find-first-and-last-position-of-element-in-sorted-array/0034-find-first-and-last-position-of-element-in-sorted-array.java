class Solution {
    public int startPos(int[] nums, int target){
        int l=0,h=nums.length-1,res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]>target){
                h=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                res=mid;
                h=mid-1;
            }
        }
        return res;
    }
    public int lastPos(int[] nums, int target){
        int l=0,h=nums.length-1,res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]>target){
                h=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                res=mid;
                l=mid+1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=startPos(nums,target);
        ans[1]=lastPos(nums,target);
        return ans;
    }
}