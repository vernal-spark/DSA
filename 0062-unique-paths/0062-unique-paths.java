class Solution {
    public static int pathCount(int row,int column,int m,int n,int[][] grid){
        if(row==m-1 && column==n-1){
             return 1;
        }
        if(row>=m || column>=n){
            return 0;
        }
        if(grid[row][column]!=-1){
            return grid[row][column];
        }
        else {
            grid[row][column]=pathCount(row+1,column,m,n,grid)+pathCount(row,column+1,m,n,grid);
            return grid[row][column];
        }
    }
    public int uniquePaths(int m, int n) {
        int[][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=-1;
            }
        }
        int num = pathCount(0,0,m,n,grid);
        if(m==1 && n==1){
            return num;
        }
        return grid[0][0];
    }
}