import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int j = 0;

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        for (int i = k; i < nums.length; i++) {
            ans[j++] = nums[dq.peekFirst()];

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        ans[j] = nums[dq.peekFirst()];
        return ans;
    }
}
