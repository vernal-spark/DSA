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
import java.util.*;

class Solution {
    public int amountOfTime(TreeNode root, int start) {
       
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
        
        TreeNode startNode = mapParentToChildNodes(root, start, parentMap);
        
        
        return infectTime(startNode, parentMap);
    }

    private TreeNode mapParentToChildNodes(TreeNode root, int start, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) {
                startNode = node;
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }
        }

        return startNode;
    }

    private int infectTime(TreeNode start, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(start);
        visited.add(start);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean infectionSpread = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                
                if (node.left != null && !visited.contains(node.left)) {
                    infectionSpread = true;
                    q.add(node.left);
                    visited.add(node.left);
                }

               
                if (node.right != null && !visited.contains(node.right)) {
                    infectionSpread = true;
                    q.add(node.right);
                    visited.add(node.right);
                }

                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    infectionSpread = true;
                    q.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }

            if (infectionSpread) {
                time++;
            }
        }

        return time;
    }
}
