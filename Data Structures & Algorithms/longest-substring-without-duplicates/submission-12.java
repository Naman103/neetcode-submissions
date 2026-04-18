class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLength = 0;
        HashSet<Character> subStrSet = new HashSet<>();
        while(r < s.length()) {
            while(subStrSet.contains(s.charAt(r))) {
                subStrSet.remove(s.charAt(l));
                l++;
            }

            subStrSet.add(s.charAt(r));
            maxLength = Math.max(r - l + 1, maxLength);
            r++;
        }

        return maxLength;
    }
}
