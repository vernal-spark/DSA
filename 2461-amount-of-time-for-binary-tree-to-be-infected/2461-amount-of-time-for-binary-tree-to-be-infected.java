class Solution {
    class Distance {
        int val;
        Distance(int val) {
            this.val = val;
        }
    }

    public int findMax(TreeNode root, int start, Distance d) {
        if (root == null) return 0;

        Distance ld = new Distance(-1);
        Distance rd = new Distance(-1);

        int lh = findMax(root.left, start, ld);
        int rh = findMax(root.right, start, rd);  // ✅ FIXED

        if (root.val == start) {
            d.val = 0;
            return Math.max(lh, rh);
        }

        if (ld.val >= 0) {
            d.val = ld.val + 1;
            return Math.max(d.val + rh, lh);  // Distance from fire to right side
        }

        if (rd.val >= 0) {
            d.val = rd.val + 1;
            return Math.max(d.val + lh, rh);  // Distance from fire to left side
        }

        return Math.max(lh, rh) + 1;
    }

    public int amountOfTime(TreeNode root, int start) {
        Distance d = new Distance(-1);
        return findMax(root, start, d);
    }
}
