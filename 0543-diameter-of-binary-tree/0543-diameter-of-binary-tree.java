/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    static class Height
    {
        int h;
    }

    public static int diameter(TreeNode root, Height height) {
        if (root == null) {
            height.h = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int ld = diameter(root.left, lh);
        int rd = diameter(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h, Math.max(ld, rd));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return diameter(root, new Height());
    }
}