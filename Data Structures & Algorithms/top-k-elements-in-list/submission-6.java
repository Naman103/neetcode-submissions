class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int num : freqMap.keySet())
            maxHeap.offer(new int[] {num, freqMap.get(num)});
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
            result[i] = maxHeap.poll()[0];

        return result;
    }
}
