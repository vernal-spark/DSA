class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tp=0,tc=0;
        for(int i=0;i<gas.length;i++){
            tp+=gas[i];
            tc+=cost[i];
        }
        if(tp<tc)return -1;
        int cp=0,start=0;
        for(int i=0;i<gas.length;i++){
            cp+=gas[i]-cost[i];
            if(cp<0){
                start=i+1;
                cp=0;
            }
        }
        return start;
    }
}