class Solution {
    public static boolean checkForAdj(int row, int col, char[][] board){
        if(row==0 && col==0){
            return false;
        }
        if(row==0){
            return board[row][col-1]=='X';
        }
        if(col==0){
            return board[row-1][col]=='X';
        }
        return (board[row][col-1]=='X'|| board[row-1][col]=='X');
    }
    public int countBattleships(char[][] board) {
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='X'){
                    if(!checkForAdj(i,j,board)){
                        count++;
                    }   
                }
            }
        }
        return count;
    }
}