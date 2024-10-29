class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> row= new ArrayList<List<Integer>>(numRows);
        for(int i=0;i<numRows;i++){
            List<Integer> col=new ArrayList<Integer>(i+1);
            while(col.size()<=i){
                col.add(1);
            }
            int mid=i>>1;
            for(int k=1;k<=mid;k++){
                int val=row.get(i-1).get(k-1)+row.get(i-1).get(k);
                col.set(k,val);
                col.set(col.size()-k-1,val);
            }
            row.add(col);
        }
        return row;
    }
}