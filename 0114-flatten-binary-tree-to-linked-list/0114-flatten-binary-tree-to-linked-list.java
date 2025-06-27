class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Traverse right before left (postorder reversed)
        flatten(root.right);
        flatten(root.left);

        // Rearranging pointers
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
