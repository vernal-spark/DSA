class Solution {
    public String convert(String s, int numRows) {
         if (numRows == 1) {
            return s;
        }

        // Array to store strings for each row
        String[] ans = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            ans[i] = "";
        }

        int i = 0;
        int len = s.length();
        
        // Traverse the string in a zigzag manner
        while (i < len) {
            // Vertically down
            for (int j = 0; i < len && j < numRows; j++) {
                ans[j] += s.charAt(i++);
            }
            // Obliquely up
            for (int j = numRows - 2; i < len && j > 0; j--) {
                ans[j] += s.charAt(i++);
            }
        }

        // Concatenate all rows to get the final string
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            result.append(ans[k]);
        }

        return result.toString();
    }
}