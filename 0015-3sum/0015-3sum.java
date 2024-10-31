class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i;
            int low=i+1,high=nums.length-1;
            while(low<high){
                if(low>i+1 && nums[low]==nums[low-1]){
                    low++;
                    continue;
                }
                if(high<nums.length-1 && nums[high]==nums[high+1]){
                    high--;
                    continue;
                }
                int sum = nums[j]+nums[low]+nums[high];
                if(sum==0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[j]);
                    l.add(nums[low]);
                    l.add(nums[high]);
                    ans.add(l);
                    low++;
                    high--;
                }
                else if(sum>0){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return ans;
    }
}