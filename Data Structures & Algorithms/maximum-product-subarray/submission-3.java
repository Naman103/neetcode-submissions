class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], maxCur = 1, minCur = 1;
        for (int num : nums) {
            int temp = num * maxCur;
            maxCur = Math.max(Math.max(maxCur * num, minCur * num), num);
            minCur = Math.min(Math.min(temp, minCur * num), num);

            res = Math.max(maxCur, res);
        }

        return res;
    }
}
