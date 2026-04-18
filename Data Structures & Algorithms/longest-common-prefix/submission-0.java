class Solution {
    public String longestCommonPrefix(String[] strs) {
        String compareString = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            compareString = fetchCommonSubString(compareString, currentString);
            if (compareString == "")
                return "";
        }

        return compareString;
    }

    public String fetchCommonSubString(String s1, String s2) {
        String commonSubString = "";
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                commonSubString += s1.charAt(i);
            else
                break;
        }

        return commonSubString;
    }
}