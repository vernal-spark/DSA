class Solution {
    public class RelativeComparator implements Comparator<Integer>{
        List<Integer> relativeArr;
        RelativeComparator(int[] arr){
            this.relativeArr = new ArrayList<>();
            for (int num : arr) {
                relativeArr.add(num);
            }
        }
        public int compare(Integer a, Integer b){
            if(relativeArr.indexOf(b)>=0 && relativeArr.indexOf(a)>=0){
                return relativeArr.indexOf(a) - relativeArr.indexOf(b);
            }
            else if(relativeArr.indexOf(b)>=0){
                return 1;
            }
            else if(relativeArr.indexOf(a)>=0){
                return -1;
            }
            return a-b;
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        list.sort(new RelativeComparator(arr2));
        for(int i=0;i<arr1.length;i++){
            arr1[i]=list.get(i);
        }
        return arr1;
    }
}