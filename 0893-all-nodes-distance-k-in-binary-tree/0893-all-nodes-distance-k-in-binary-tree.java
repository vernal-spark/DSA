/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void mapParent(TreeNode node, HashMap<TreeNode, TreeNode> childParentMap) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                childParentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                childParentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> h = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        mapParent(root, h);
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int currDistance = 0;
        while (!q.isEmpty() && currDistance <= k) {
            int size = q.size();
            if (currDistance == k) {
                for (int i = 0; i < size; i++) {
                    ans.add(q.poll().val);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                visited.add(curr);
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                }
                if (h.containsKey(curr) && !visited.contains(h.get(curr))) {
                    q.add(h.get(curr));
                }
            }
            currDistance++;
        }
        return ans;
    }
}