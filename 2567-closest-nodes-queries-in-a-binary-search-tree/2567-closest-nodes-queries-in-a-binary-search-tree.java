/**
 * Ultra-optimized version using single binary search per query
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // Convert BST to sorted array
        List<Integer> sortedValues = new ArrayList<>();
        inorder(root, sortedValues);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int query : queries) {
            // Single binary search to find insertion point
            int pos = Collections.binarySearch(sortedValues, query);
            
            int floor = -1, ceil = -1;
            
            if(pos >= 0) {
                // Exact match found
                floor = ceil = sortedValues.get(pos);
            } else {
                // Convert to insertion point
                pos = -pos - 1;
                
                // Floor: element just before insertion point
                if(pos > 0) {
                    floor = sortedValues.get(pos - 1);
                }
                
                // Ceil: element at insertion point
                if(pos < sortedValues.size()) {
                    ceil = sortedValues.get(pos);
                }
            }
            
            ans.add(Arrays.asList(floor, ceil));
        }
        
        return ans;
    }
    
    private void inorder(TreeNode node, List<Integer> values) {
        if(node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
}