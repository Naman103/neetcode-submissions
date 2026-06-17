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

        return Arrays.equals(sHashTable, tHashTable);

    }
}

// Always check length first
// Brute Force (Solution 1) : Sort both strings if sorted strings are same they are anagrams
// Solution2 (HashTable/HashMap) : iterate both string and mantain count of character. After that compare hash table if theya re same or not















