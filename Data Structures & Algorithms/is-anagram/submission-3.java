class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sChar = new int[26];
        int[] tChar = new int[26];

        for(char sc : s.toCharArray()) 
            sChar[sc - 'a']++;

        for(char tc : t.toCharArray())
            tChar[tc - 'a']++;
        
        for(int i = 0; i < 26; i++) {
            if(tChar[i] != sChar[i])
                return false;
        }

        return true;

    }
}
