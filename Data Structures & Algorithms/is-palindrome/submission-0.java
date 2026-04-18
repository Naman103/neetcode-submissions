class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while(start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(isAlphaNumeric(startChar) && isAlphaNumeric(endChar)) {
                if(startChar != endChar)
                    return false;
                start++;
                end--;
            } else if(!isAlphaNumeric(startChar)) {
                start++;
            } else if(!isAlphaNumeric(endChar)) {
                end--;
            }
        }

        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        if((ch >= 'A' && ch <= 'Z') || (ch >='a' && ch <= 'z')
        || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
}
