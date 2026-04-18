class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1FreqCount = new int[26];
        for(char c : s1.toCharArray())
            s1FreqCount[c - 'a']++;
        
        for(int l = 0; l < s2.length(); l++) {
            int[] subStrFreqCount = new int[26];
            subStrFreqCount[s2.charAt(l) - 'a']++;
            if(compareFreqArray(s1FreqCount, subStrFreqCount))
                return true;

            for(int r = l + 1; r < s2.length(); r++) {
                subStrFreqCount[s2.charAt(r) - 'a']++;
                if(compareFreqArray(s1FreqCount, subStrFreqCount))
                return true;
                
            }
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
