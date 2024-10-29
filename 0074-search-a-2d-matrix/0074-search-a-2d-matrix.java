class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s=0,e=matrix.length-1,mid,row;
        while(s<=e){
            mid=(s+e)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[mid].length-1]){
                if(Arrays.binarySearch(matrix[mid],target)>=0){
                    return true;
                }
                break;
            }
            else if(target<matrix[mid][0]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return false;
    }
}