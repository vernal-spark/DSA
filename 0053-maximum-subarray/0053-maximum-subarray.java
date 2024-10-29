class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax=nums[0],localMax=nums[0];
        for(int i=1;i<nums.length;i++){
             localMax=localMax+nums[i]>nums[i]?localMax+nums[i]:nums[i];
             globalMax=Math.max(localMax,globalMax);
        }
        return globalMax;
    }
}