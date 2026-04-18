class Solution {
    public int numDecodings(String s) {
        return decode(s, s.length());
    }

    public int decode(String s, int index) {
        if(index == 0)
            return 1;
        
        if(index == 1 && s.charAt(index - 1) - '0' > 0)
            return 1;
        else if(index == 1)
            return 0;
        
        int oneDigit = Integer.parseInt(s.substring(index - 1, index));
        int twoDigit = Integer.parseInt(s.substring(index - 2, index));
        
        int res = 0;
        if(oneDigit > 0)
            res += decode(s, index - 1);
        
        if(twoDigit >= 10 && twoDigit <= 26)
            res += decode(s, index - 2); 
        
        return res;
    }
}
