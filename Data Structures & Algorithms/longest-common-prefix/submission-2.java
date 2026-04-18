class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonString = getCommonString(commonString, strs[i]);
        }

        return commonString;
    }

    private String getCommonString(String s1, String s2) {
        StringBuilder commonString = new StringBuilder();
        int size = Math.min(s1.length(), s2.length());
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            
            commonString.append(s1.charAt(i));
        }

        return commonString.toString();
    }
}