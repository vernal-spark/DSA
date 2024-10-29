class Solution {
    public static int maxSubarraySum(int[] nums){
        int localMax=nums[0],globalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            localMax=Math.max(nums[i],localMax+nums[i]);
            globalMax=Math.max(localMax,globalMax);
        }
        return globalMax;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = maxSubarraySum(nums);
        if(maxSum<0){
            return maxSum;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=-nums[i];
        }
        int maxCircular=maxSubarraySum(nums)+sum;
        return Math.max(maxCircular,maxSum);
    }
}
