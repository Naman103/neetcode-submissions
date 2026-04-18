class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones)
            heap.offer(stone);

        // fetch 2 heaviest stone 
        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if(x != y)
                heap.offer(Math.abs(x - y));
        }
        
        if(heap.size() == 0)
            return 0;
        
        return heap.peek();
    }

}
