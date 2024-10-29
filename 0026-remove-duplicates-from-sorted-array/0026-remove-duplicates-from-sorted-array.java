class Solution {
    public int removeDuplicates(int[] nums) {
        int res=1;
        for(int i=0;i<nums.length;i++){
            if(nums[res-1]!=nums[i]){
                nums[res++]=nums[i];
            }
        }
        return res;
    }
}