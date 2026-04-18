class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        while(r < s.length()) {
            while(charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            } 

            charSet.add(s.charAt(r));
            maxLength = Math.max(r - l + 1, maxLength);
            r++;
        }

        return maxLength;
    }
}
