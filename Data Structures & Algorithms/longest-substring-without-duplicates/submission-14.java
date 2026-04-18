class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        Set<Character> subString = new HashSet<>();
        int left = 0, right = 1, maxLength = 1;

        subString.add(s.charAt(left));
        while (left < right && right < s.length()) {
            char c = s.charAt(right);
            while (subString.contains(c)) {
                maxLength = Math.max(subString.size(), maxLength);
                subString.remove(s.charAt(left));
                left++;
            }

            subString.add(c);
            right++;    
        }

        return Math.max(subString.size(), maxLength);
    }
}
