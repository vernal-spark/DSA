public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < nodes.length) {
            TreeNode curr = q.poll();

            // Left child
            if (!nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.left);
            }
            i++;

            // Right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
