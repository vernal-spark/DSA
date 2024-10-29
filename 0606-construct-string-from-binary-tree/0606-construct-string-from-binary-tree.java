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
    public static void preorder(TreeNode root, StringBuilder r){
        if(root==null){
            return;
        }
        r.append(String.valueOf(root.val));
        if(root.left==null && root.right==null){
            return;
        }
        r.append('(');
        preorder(root.left,r);
        r.append(')');
        if(root.right != null){
            r.append('(');
            preorder(root.right,r);
            r.append(')');
        }
        
    }
    public String tree2str(TreeNode root) {
        StringBuilder r = new StringBuilder();
        preorder(root,r);
        return r.toString();
    }
}