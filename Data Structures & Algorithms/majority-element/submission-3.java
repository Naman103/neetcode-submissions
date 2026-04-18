class Solution {
    public int majorityElement(int[] nums) {
        int result = -1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) > n/2)
                result = key;
        }

        return result;

    }
}