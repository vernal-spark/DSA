import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n; 
            
            while (!s.isEmpty() && nums[s.peek()] < nums[currentIndex]) {
                ans[s.pop()] = nums[currentIndex];
            }
            
            if (i < n) {
                s.push(currentIndex);
            }
        }

        return ans;
    }
}
