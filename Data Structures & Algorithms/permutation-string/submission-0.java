class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] charCount1 = new int[26];
        for(int i = 0; i < s1.length(); i++)
            charCount1[s1.charAt(i) - 'a']++;
        
        int[] charCount2 = new int[26];
        boolean result = false;
        int left = 0, right = 0;
        while(right < s2.length()) {
            charCount2[s2.charAt(right) - 'a']++;
            if(right - left + 1 == s1.length()) {
                if(compareCharArray(charCount1, charCount2))
                    return true;
                else {
                    charCount2[s2.charAt(left) - 'a']--;
                    left++;
                }
            }

            right++;
        }

        return false;
    }

    public boolean compareCharArray(int[] charCount1, int[] charCount2) {
        for(int i = 0; i < 26; i++) {
            if(charCount1[i] != charCount2[i])
                return false;
        }

        return true;
    }
}
