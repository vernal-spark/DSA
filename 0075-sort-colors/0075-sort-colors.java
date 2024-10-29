class Solution {
    public void sortColors(int[] nums) {
        // int s=0,e=nums.length-1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]==0){
        //         int temp=nums[s];
        //         nums[s]=nums[i];
        //         nums[i]=temp;
        //         s++;
        //     }
        //     else if(nums[i]==2){
        //         int temp=nums[e];
        //         nums[e]=nums[i];
        //         nums[i]=temp;
        //         e--;
        //     }
        // }     
        Arrays.sort(nums);
    }
}