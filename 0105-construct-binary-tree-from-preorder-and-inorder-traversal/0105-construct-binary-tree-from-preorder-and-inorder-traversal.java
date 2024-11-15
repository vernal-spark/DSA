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
    int preIndex = 0;
    Map<Integer, Integer> m = new HashMap<>();

    private TreeNode b(int[] preorder, int[] inorder, int inStart, int inEnd){
        if(inStart>inEnd)return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inRoot = m.get(preorder[preIndex++]);
        int numsLeft = inRoot - inStart;
        root.left = b(preorder,inorder,inStart,inRoot-1);
        root.right = b(preorder,inorder,inRoot+1,inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        TreeNode root = b(preorder, inorder, 0, inorder.length - 1);
        return root;
    }
}