class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const visitedMap = new Map();
        for (let i = 0; i < nums.length; i++) {
            const complement = target - nums[i];
            if (visitedMap.has(complement)) {
                return [visitedMap.get(complement), i];
            }

            visitedMap.set(nums[i], i);
        }
    }
}
