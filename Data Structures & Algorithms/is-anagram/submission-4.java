class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] sHashTable = new char[26];
        char[] tHashTable = new char[26];

        for(int i = 0; i < t.length(); i++) {
            sHashTable[s.charAt(i) - 'a']++;
            tHashTable[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(sHashTable[i] != tHashTable[i])
                return false;
        }

        return true;

    }
}
