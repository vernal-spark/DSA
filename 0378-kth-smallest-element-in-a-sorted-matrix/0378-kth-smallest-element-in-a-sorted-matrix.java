class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(q.size()<k){
                    q.add(matrix[i][j]);
                }
                else if(q.size()==k && q.peek()>matrix[i][j]){
                    q.poll();
                    q.add(matrix[i][j]);
                }
            }
        }
        return q.peek();
    }
}