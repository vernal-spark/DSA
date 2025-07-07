/**
 * Morris Traversal approach for O(1) space complexity
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                // Process current node
                if (prev != null && prev.val > curr.val) {
                    if (first == null) {
                        first = prev;
                        second = curr;
                    } else {
                        second = curr;
                    }
                }
                prev = curr;
                curr = curr.right;
            } else {
                // Find inorder predecessor
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    // Create threading
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // Remove threading and process current node
                    pre.right = null;
                    if (prev != null && prev.val > curr.val) {
                        if (first == null) {
                            first = prev;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        // Swap the values
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}