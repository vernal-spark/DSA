class Solution {
    public void rotate(int[][] matrix) {
        
        int a[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                a[i][j]=matrix[matrix[0].length-1-j][i];
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=a[i][j];
            }
        }
        // public static void reverse(int[][] matrix, int row){
        //     int low=0,high=matrix[row].length
        // }
        // for(int i=0;i<matrix.length;i++){
        //     reverse(matrix,i)
        // }
    }
}