/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev=null;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                if(prev!=null && curr.val<=prev.val){
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
            else{
                TreeNode pre = curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    if(curr.val<=prev.val){
                        return false;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return true;
    }
}