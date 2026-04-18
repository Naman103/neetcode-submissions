class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charFrequencies = new int[26];
        for (char c : tasks)
            charFrequencies[c - 'A']++;
        
        Map<Integer, Integer> lastCycleCharUsedMap = new HashMap<>();
        int curCPUCycle = 0;
        boolean isAllCharacterCovered = false;
        while (!isAllCharacterCovered) {
            int maxFreqCharacter = -1;
            int maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                int lastCycleCharUsed = lastCycleCharUsedMap.getOrDefault(i, -1);
                if (lastCycleCharUsed != -1 && curCPUCycle - lastCycleCharUsed <= n)
                    continue;
                if (charFrequencies[i] > maxFreq) {
                    maxFreq = charFrequencies[i];
                    maxFreqCharacter = i;
                }
            }
            
            
            if (maxFreqCharacter != -1) {
                lastCycleCharUsedMap.put(maxFreqCharacter, curCPUCycle);
                charFrequencies[maxFreqCharacter]--; 
            }
            
            curCPUCycle++;

            isAllCharacterCovered = true;
            for (int i = 0; i < 26; i++) {
                if (charFrequencies[i] != 0) {
                    isAllCharacterCovered = false;
                    break;
                }
            }
        }

        return curCPUCycle;
    }
}
