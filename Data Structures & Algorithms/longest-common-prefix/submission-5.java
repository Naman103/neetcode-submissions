class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) 
            minLength = Math.min(s.length(), minLength);
        
        String result = "";
        char curChar;
        for (int i = 0; i < minLength; i++) {
            curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (curChar != strs[j].charAt(i))
                    return result;
            }

            result += curChar;
        }

        return result;
    }
}