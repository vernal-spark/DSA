import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int i = 0, max_area = 0;
        Stack<Integer> s = new Stack<>();
        
        while (i < heights.length) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                int area = heights[t] * width;
                max_area = Math.max(max_area, area);
            }
        }
        
        while (!s.isEmpty()) {
            int t = s.pop();
            int width = s.isEmpty() ? i : i - s.peek() - 1;
            int area = heights[t] * width;
            max_area = Math.max(max_area, area);
        }
        
        return max_area;
    }
}
