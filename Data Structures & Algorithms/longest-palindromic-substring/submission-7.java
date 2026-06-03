class Solution {
    public String longestPalindrome(String s) {
        String result = s.charAt(0) + "";
        int i = 0, j = 0;
        while (i < s.length()) {
            j = i + 1;
            while (j < s.length()) {
                if(isPallindrome(s, i, j) && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            
                j++;
            }
            i++;
        }

        return result;
    }

    private boolean isPallindrome(String s, int sIndex, int lIndex) {
        while (sIndex < lIndex) {
            if (s.charAt(sIndex) != s.charAt(lIndex))
                return false;
            sIndex++;
            lIndex--;
        }

        return true;
    }
}
