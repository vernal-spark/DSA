class Solution {
    private boolean isIncrease(int[] nums, int start, int end){
        for(int i = start; i < end; i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
    private boolean isDecrease(int[] nums, int start, int end){
        for(int i = start; i < end; i++){
            if(nums[i]<nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        int min = 0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[min]>=nums[i]){
                min = i;
            }
        }
        if(isIncrease(nums,0,n-1)){
            return true;
        }
        else if(isIncrease(nums,0,min-1) && isIncrease(nums,min,n-1) && nums[0]>=nums[n-1]){
            return true;
        }
        
        return false;
    }
}