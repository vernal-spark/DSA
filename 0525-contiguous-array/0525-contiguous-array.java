class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==0){
                count=i+1;
            }
            if(h.containsKey(sum)){
                if(count<i-h.get(sum)){
                    count=i-h.get(sum);
                }
            }
            else h.put(sum,i);
        }
        return count;       
    }
}