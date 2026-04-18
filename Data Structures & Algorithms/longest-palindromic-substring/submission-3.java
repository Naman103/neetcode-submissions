class Solution {
    String res = "";
    HashMap<String, Integer> map;
    public String longestPalindrome(String s) {
       if(s.length() == 1) return s;
       map = new HashMap<>();
       helper(s, 0, s.length()); 
       return res;
       
    }

    public int helper(String s, int start, int end) {
        if(map.containsKey(s.substring(start, end))) {
            return map.get(s.substring(start, end));
        }

        if(start >= end || start >= s.length() || end < 0) {
            return res.length();
        }
   
        map.put(s.substring(start, end), Math.max(end - start, res.length()));
        if(isPallindrome(s, start, end - 1) && end - start > res.length())
            res = s.substring(start, end);

         return Math.max(res.length(), Math.max(helper(s, start+1, end), helper(s, start, end-1)));
    }

    public boolean isPallindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}
