class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int startSubStringIndex = 0;
        int endSubStringIndex = 0;
        int maxLengthOfSubString = 1;

        HashSet<Character> subStrCharacters = new HashSet<>();
        
        while(endSubStringIndex < s.length()) {
            char newSubStrChar = s.charAt(endSubStringIndex);
            if(subStrCharacters.contains(newSubStrChar)) {
                maxLengthOfSubString = Math.max(subStrCharacters.size(), maxLengthOfSubString);
                while(subStrCharacters.contains(newSubStrChar))
                    subStrCharacters.remove(s.charAt(startSubStringIndex++));
            } else {
                subStrCharacters.add(newSubStrChar);
                endSubStringIndex++;
            }
        }

        return Math.max(subStrCharacters.size(), maxLengthOfSubString);
    }
}
