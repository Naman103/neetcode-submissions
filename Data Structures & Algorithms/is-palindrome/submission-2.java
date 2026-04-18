class Solution {
    public boolean isPalindrome(String s) {
       s = s.toLowerCase();
       int start = 0, end = s.length() - 1;
       while(start < end) {

        if(isValid(s.charAt(start)) &&  
        isValid(s.charAt(end))) {
        if (s.charAt(start) != s.charAt(end)) {
            return false;

        }

        start++;
        end--;
       }

        if(!isValid(s.charAt(start)))
            start++;
        
        if(!isValid(s.charAt(end)))
            end--;
        
        

       }

       return true;

    }

    public boolean isValid(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        
        return false;
    }
}
