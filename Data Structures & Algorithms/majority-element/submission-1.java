class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        int maxFreqElement = -1, maxFreq = 0;
        for(int num : freqMap.keySet()) {
            if (freqMap.get(num) > maxFreq) {
                maxFreqElement = num;
                maxFreq = freqMap.get(num);
            }
        }

        return maxFreqElement;
    }
}