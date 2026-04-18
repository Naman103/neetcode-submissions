class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stoneWeight : stones)
            maxHeap.offer(stoneWeight);
        
        while (maxHeap.size() > 1) 
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
    

        return maxHeap.poll();
    }
}
