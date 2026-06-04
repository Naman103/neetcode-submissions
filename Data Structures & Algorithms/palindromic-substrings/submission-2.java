class Solution {
    public int countSubstrings(String s) {
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

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (subIndex[i][j])
                    count++;
            }
        }

        return count;
    }

}
