class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row =new ArrayList<Integer>();
        ArrayList<Integer> col=new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i:row){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=0;
            }
        }
        for(int i:col){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }
    }
}