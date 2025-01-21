class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        int min = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-min>maxDiff && nums[i]>min){
                maxDiff = nums[i]-min;
            }
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return maxDiff==Integer.MIN_VALUE?-1:maxDiff;
    }
}