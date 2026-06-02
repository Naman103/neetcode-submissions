class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        const freqCount = [];
        for (const num of nums) {
            freqCount[num] = (freqCount[num] || 0) + 1;
        }

        let minHeap = new MinPriorityQueue((x) => x[1]);
        for (const [num, cnt] of Object.entries(freqCount)) {
            minHeap.enqueue([num, cnt]);
            if (minHeap.size() > k)
                minHeap.dequeue();
        }

        const res = [];
        for (let i = 0; i < k; i++) {
            res.push(minHeap.dequeue()[0]);
        }

        return res;
    }
}
