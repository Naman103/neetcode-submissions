class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sHash = prepareHashTable(s);
        int[] tHash = prepareHashTable(t);
        return Arrays.equals(sHash, tHash);
    }

    private int[] prepareHashTable(String s) {
        int[] hashTable = new int[26];
        for (char c : s.toCharArray())
            hashTable[c - 'a']++;
        return hashTable;
    }
}
