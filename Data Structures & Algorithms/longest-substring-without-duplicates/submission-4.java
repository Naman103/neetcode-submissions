class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        int l = 0, r = 1, maxLength = 1;
        HashSet<Character> sCharSet = new HashSet<>();
        sCharSet.add(s.charAt(l));
        while(l < r && r < s.length()) {
            if(sCharSet.contains(s.charAt(r))) {
                maxLength = Math.max(maxLength, r - l );
                while(sCharSet.contains(s.charAt(r))) {
                    sCharSet.remove(s.charAt(l));
                    l++;
                }
            }

            sCharSet.add(s.charAt(r));
            r++;
        }

        return Math.max(maxLength, r - l );
    }
}
