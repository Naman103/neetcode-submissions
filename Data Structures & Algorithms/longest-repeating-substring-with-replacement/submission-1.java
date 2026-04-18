class Solution {
    public int characterReplacement(String s, int k) {
        int[] charArray = new int[26];
        int left = 0, right = 0 ,maxFreq = 0, result = 0;
        while(right < s.length()) {
            charArray[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, charArray[s.charAt(right) - 'A']);
            while(right -left + 1 - maxFreq > k) {
                charArray[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }

}
