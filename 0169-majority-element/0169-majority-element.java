class Solution {
    public int majorityElement(int[] nums) {
        int index=0,count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[index]==nums[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                index=i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[index]==nums[i]){
                count++;
            }
        }
        if(count > nums.length/2){
            return nums[index];
        }
        return -1;
    }
}