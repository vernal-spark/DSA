class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                seen[i][j]=false;
            }
        }
        int[] dr={0,1,0,-1},dc={1,0,-1,0};
        int d=0,count=0,row=0,col=0;
        while(count<m*n){
            ans.add(matrix[row][col]);
            seen[row][col]=true;
            int r = row+dr[d];
            int c = col+dc[d];
            if(0<=r && r<m && 0<=c && c<n && !seen[r][c]){
                row=r;
                col=c;
            }
            else{
                d=(d+1)%4;
                row+=dr[d];
                col+=dc[d];
            }
            count++;
        }
        return ans;
    }
}