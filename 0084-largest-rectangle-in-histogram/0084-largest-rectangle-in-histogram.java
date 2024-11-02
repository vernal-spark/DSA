import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left_small = new int[n];
        int[] right_small = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            left_small[i] = (s.isEmpty()) ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            right_small[i] = (s.isEmpty()) ? n : s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right_small[i] - left_small[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
