class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sHash = new int[26];
        int[] tHash = new int[26];

        fillHash(sHash, s);
        fillHash(tHash, t);

        return Arrays.equals(sHash, tHash);
    }

    private void fillHash(int[] hashTable, String s) {
        for (char c : s.toCharArray())
            hashTable[c - 'a']++;
    }
}
