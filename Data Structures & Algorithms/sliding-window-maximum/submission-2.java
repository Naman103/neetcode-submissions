class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int curMax = Integer.MIN_VALUE;
        int left = 0, right = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);
        
        while (right <= n) {
            result[left] = pq.peek();
            pq.remove(nums[left]);
            if (right != n)
                pq.offer(nums[right]);
            left++;
            right++;
        }

        return result;
    }

}
