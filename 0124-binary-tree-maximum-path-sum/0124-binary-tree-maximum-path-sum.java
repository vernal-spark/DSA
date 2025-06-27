class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Only take positive gains
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        // Update the global max with the path through this node
        maxSum = Math.max(maxSum, node.val + left + right);

        // Return max gain to parent (one-sided path)
        return node.val + Math.max(left, right);
    }
}
