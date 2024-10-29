class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int start=intervals[0][0],end=intervals[0][1],count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                count++;
                if(intervals[i][1]<=end){
                    end=intervals[i][1];
                }
            }
            else {
                end=intervals[i][1];
            }
        }
        return count;
    }
}