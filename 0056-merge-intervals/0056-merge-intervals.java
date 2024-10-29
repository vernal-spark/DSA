class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));  
      
        int res = 0;  
       
        for (int i=1; i<intervals.length; i++)  
        {  
            if (intervals[res][1] >=  intervals[i][0])  
            {   
                intervals[res][1] = Math.max(intervals[res][1], intervals[i][1]);  
                intervals[res][0] = Math.min(intervals[res][0], intervals[i][0]);  
            }  
            else { 
                res++; 
                intervals[res] = intervals[i];  
            }     
        }  
        int ans[][]=new int [res+1][2];
        for (int i = 0; i <= res; i++){
            ans[i][0]=intervals[i][0];
            ans[i][1]=intervals[i][1];
        } 
            
        
        return ans;
    }
}