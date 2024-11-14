import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue();
            int firstIndex = 0, lastIndex = 0;
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue() - minIndex; // Normalize index to prevent overflow
                
                if (i == 0) firstIndex = index;
                if (i == size - 1) lastIndex = index;
                
                if (node.left != null) queue.add(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null) queue.add(new Pair<>(node.right, 2 * index + 2));
            }
            
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        
        return maxWidth;
    }
}
