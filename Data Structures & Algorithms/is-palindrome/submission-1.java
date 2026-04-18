class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(isValidChar(s.charAt(left)) && isValidChar(s.charAt(right))) {
                if(s.charAt(left) != s.charAt(right))
                    return false;
                left++;
                right--;   
            }
            
            if(!isValidChar(s.charAt(left)))
                left++;
            
            if(!isValidChar(s.charAt(right)))
                right--;
        }

        return true;
    }

    public boolean isValidChar(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        
        return false;
    }
}
