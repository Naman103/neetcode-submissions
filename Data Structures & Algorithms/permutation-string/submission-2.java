class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1FreqCount = new int[26];
        for(char c : s1.toCharArray())
            s1FreqCount[c - 'a']++;


        int l = 0, r = 0;
        int[] subStrFreqCount = new int[26];

        while(r < s2.length()) {
            subStrFreqCount[s2.charAt(r) - 'a']++;
            if(r - l + 1 == s1.length()) {
                if(compareFreqArray(s1FreqCount, subStrFreqCount))
                    return true;
                else {
                    subStrFreqCount[s2.charAt(l) - 'a']--;
                    l++;
                }
            }
            r++;
        }   

        return false;     

    }

    public static boolean compareFreqArray(int[] s1Ar, int[] s2Ar) {
        for(int i = 0; i < 26; i++) {
            if(s1Ar[i] != s2Ar[i])
                return false;
        }

        return true;
    }
}
