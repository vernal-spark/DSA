class Solution {
    
    public static boolean checkIfSpecial(int[][] mat, ArrayList<Integer> pos){
        int row=pos.get(0);
        int col=pos.get(1);
        int c=0;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]==1){
                c++;
            }
            
        }
        if(c>1){
                return false;
        }
        c=0;
        for(int i=0;i<mat[0].length;i++){
            if(mat[row][i]==1){
                c++;
            }
        }
        if(c>1){
                return false;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        ArrayList<ArrayList<Integer>> pos = new ArrayList<ArrayList<Integer>>();
        int c=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(i);
                    a.add(j);
                    pos.add(a);
                }
            }
        }
        int count=0;
        for(int i=0;i<pos.size();i++){
            // System.out.println(pos.get(i));
            if(checkIfSpecial(mat,pos.get(i))){
                count++;
            }
        }
        return count;
    }
}