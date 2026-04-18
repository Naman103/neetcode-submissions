class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) ->  a[1] - b[1]
        );

        for (int num : freqMap.keySet()) {
            minHeap.offer(new int[] {num, freqMap.get(num)});
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()) {
            result[index] = minHeap.poll()[0];
            index++;
        }

        return result;
    }
}
