class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer>a=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            a.add(nums[i]);
        }
        int i=1;
        while(a.contains(i)){
            i++;
        }
        return i;
    }
}