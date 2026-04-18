class Solution {
    int[][] startend;
    boolean[][] seb;
    public int countSubstrings(String s) {
       startend = new int[s.length() + 1][s.length() + 1];
        seb = new boolean[s.length() + 1][s.length() + 1];
        return countPallindrome(s, 0, s.length());
    }

    public int countPallindrome(String s, int start, int end) {
        if(start >= end || start >= s.length() || end < 0)
            return 0;
        
        if(seb[start][end])
            return 0;

        if(startend[start][end] != 0) {
            seb[start][end] = true;
            return startend[start][end];
        }
        int res = 0;
        if(isPallindrome(s, start, end - 1) && !seb[start][end]) {  
           // seb[start][end] = true;
            res = 1;
        }

        startend[start][end] = res + countPallindrome(s, start+1, end) + countPallindrome(s, start, end-1);
        seb[start][end] = true;
        return startend[start][end];
    }

    public boolean isPallindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
