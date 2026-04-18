class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = 0, maxSubStrLength = 0;
        int[] subStrFreq = new int[26];

        while(r < s.length()) {
            subStrFreq[s.charAt(r) - 'A']++;
            maxFreq = getMaxFreq(subStrFreq);

            int numberOfReplacements = r - l + 1 - maxFreq;
            while(numberOfReplacements > k) {
                subStrFreq[s.charAt(l) - 'A']--;
                l++;
                maxFreq = getMaxFreq(subStrFreq);
                numberOfReplacements = r - l + 1 - maxFreq;
            }

            maxSubStrLength = Math.max(r - l + 1, maxSubStrLength);
            r++;
        }

        return maxSubStrLength;
    }

    public static int getMaxFreq(int[] subStrFreq) {
        int maxFreq = 0;
        for(int i = 0; i < 26; i++)
            maxFreq = Math.max(maxFreq, subStrFreq[i]);
        
        return maxFreq;
    }
}
