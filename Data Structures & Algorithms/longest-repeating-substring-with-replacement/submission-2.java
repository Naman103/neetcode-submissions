class Solution {
    public int characterReplacement(String s, int k) {
        int currentMaxFrequency = 0;
        int startSubStringIndex = 0;
        int endSubStringIndex = 0; 
        int maxLengthAfterReplacement = 0;

        int[] charCountArray = new int[26];
        while(endSubStringIndex < s.length() && endSubStringIndex >= startSubStringIndex) {
            charCountArray[s.charAt(endSubStringIndex) - 'A']++;
            int maxFreqCharCount = Arrays.stream(charCountArray).max().getAsInt();
            
            while(endSubStringIndex - startSubStringIndex + 1 - maxFreqCharCount > k) {
                charCountArray[s.charAt(startSubStringIndex) - 'A']--;
                startSubStringIndex++;
            }
            maxLengthAfterReplacement = Math.max(endSubStringIndex - startSubStringIndex + 1, maxLengthAfterReplacement);
            endSubStringIndex++;
        }

        return maxLengthAfterReplacement;
        
    }
}
