import java.util.*;

class Solution {
    public static void right(TreeNode root, int level, List<Integer>ans){
        if(root==null)return;
        if(ans.size()==level){
            ans.add(root.val);
        }
        right(root.right,level+1,ans);
        right(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        right(root,0,ans);
        return ans;
    }
}
