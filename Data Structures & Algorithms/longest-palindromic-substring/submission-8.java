class BruteForceSolution {
    public String longesPallindromeBruteForce(String s) {   
        String result = s.charAt(0) + "";
        int i = 0, j = 0;
        
        while (i < s.length()) {
            j = i + 1;
            while (j < s.length()) {
                if(isPallindrome(s, i, j) && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            
                j++;
            }
            i++;
        }

        return result;
    }

    private boolean isPallindrome(String s, int sIndex, int lIndex) {
        while (sIndex < lIndex) {
            if (s.charAt(sIndex) != s.charAt(lIndex))
                return false;
            sIndex++;
            lIndex--;
        }

        return true;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] subIndex = new boolean[n][n];

        for(int i = 0; i < n; i++)
            subIndex[i][i] = true;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                subIndex[i - 1][i] = true;
                
            }
        }

        for (int i = 0; i < n; i++) {
            int jStart = i - 1, jEnd = i + 1;
            while(jStart >= 0 && jEnd < n && s.charAt(jStart) == s.charAt(jEnd)) {
                subIndex[jStart][jEnd] = true;
                jStart--;
                jEnd++;
            }
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                int jStart = i - 2, jEnd = i + 1;
                while(jStart >= 0 && jEnd < n && s.charAt(jStart) == s.charAt(jEnd)) {
                    subIndex[jStart][jEnd] = true;
                    jStart--;
                    jEnd++;
                }
            }
        }


        int maxLength = 1;
        int[] maxPalIndex = new int[2];
        maxPalIndex[0] = -1;
        maxPalIndex[1] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (subIndex[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    maxPalIndex[0] = i;
                    maxPalIndex[1] = j;
                }
            }
        }

        String result = "";
        if (maxLength == 1) {
            result = s.charAt(0) + "";
        } else {
            result = s.substring(maxPalIndex[0], maxPalIndex[1] + 1);
        }

        return result;
    }  
}
