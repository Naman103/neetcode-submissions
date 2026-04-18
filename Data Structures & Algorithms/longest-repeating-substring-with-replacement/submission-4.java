class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int left = 0, right = 0, maxSubStrLength = 0;
        int maxCharCount = 0;
        while (right < s.length()) {
            charCount[s.charAt(right) - 'A']++;
            maxCharCount = findMaxCharCount(charCount);
            int subStrLength = right - left + 1;
            while (subStrLength - maxCharCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
                maxCharCount = findMaxCharCount(charCount);
                subStrLength = right - left + 1;
            }

            maxSubStrLength = Math.max(subStrLength, maxSubStrLength);
            right++;
        }

        return maxSubStrLength;   
    }

    private int findMaxCharCount(int[] charCount) {
        int maxCount = 0;
        for (int count : charCount) 
            maxCount = Math.max(count, maxCount);
        
        return maxCount;
    }
}
