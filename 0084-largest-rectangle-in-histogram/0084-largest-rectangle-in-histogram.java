import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        
        int area = arr[0];
        int i = 0;
        
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        for (int j = 0; j < n; j++) {
            leftSmaller[j] = -1;
            rightSmaller[j] = n;
        }
        
        while (i < n) {
            while (!s.isEmpty() && s.peek() != -1 && arr[s.peek()] > arr[i]) {
                rightSmaller[s.peek()] = i;
                s.pop();
            }
            
            if (i > 0 && arr[i] == arr[i - 1]) {
                leftSmaller[i] = leftSmaller[i - 1];
            } else {
                leftSmaller[i] = s.peek();
            }
            
            s.push(i);
            i++;
        }
        
        for (int j = 0; j < n; j++) {
            int currentArea = arr[j] * (rightSmaller[j] - leftSmaller[j] - 1);
            area = Math.max(area, currentArea);
        }
        
        return area;
    }
}
