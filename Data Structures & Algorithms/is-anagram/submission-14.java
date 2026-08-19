class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] sTable = freqCount(s);
        int[] tTable = freqCount(t);
        
        for (int i = 0; i < 26; i++)
            if (sTable[i] != tTable[i])
                return false;
        
        return true;
    }

    private int[] freqCount(String s) {
        int[] sTable = new int[26];
        for (char c : s.toCharArray())
            sTable[c - 'a']++;
        return sTable;
    }
}
