class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int longest=1;
        HashSet<Integer>h=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }
        for(int i : h){
            if(!h.contains(i-1)){
                int x=i;
                int count=1;
                while(h.contains(x+1)){
                    count++;
                    x+=1;
                }
                longest=Math.max(count,longest);
            }
        }
        return longest;

    }
}