class Solution {
    public class MapComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2){
            return e1.getValue()-e2.getValue()==0?e2.getKey()-e1.getKey():e1.getValue()-e2.getValue();
        }

    }
    public int[] frequencySort(int[] nums) {
        int ans[]= new int[nums.length];
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(h.entrySet());
        list.sort(new MapComparator());
        int k=0;
        for(int i=0;i<list.size();i++){
            int ele=list.get(i).getKey();
            while(h.get(ele)>0){
                ans[k++]=ele;
                h.put(ele,h.get(ele)-1);
            }
        }
        return ans;
    }
}