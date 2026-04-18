class Solution {
    public boolean isPalindrome(String s) {
       s = s.toLowerCase();
       int start = 0, end = s.length() - 1;
       while(start < end) {
        if(!isValidChar(s.charAt(start)))
            start++;
        else if(!isValidChar(s.charAt(end)))
            end--;
        else if (s.charAt(start) != s.charAt(end))
            return false;
        else {
            start++;
            end--;
        }
       }

       return true; 
    }

    private boolean isValidChar(char c) {
        if( (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        
        return false;
    }
}
