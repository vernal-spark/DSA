class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        HashMap<Character, Integer> h = new HashMap<>();
        int maxLength = 0;
        int start = 0; 

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (h.containsKey(c)) {
                start = Math.max(start, h.get(c) + 1);
            }

            h.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}