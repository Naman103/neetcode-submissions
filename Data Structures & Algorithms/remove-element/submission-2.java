class Solution {
    public int removeElement(int[] nums, int val) {
        int startIndex = 0, endIndex = nums.length;
        while (startIndex < endIndex) {
            if (nums[startIndex] == val)
                nums[startIndex] = nums[--endIndex];
            else
                startIndex++;
        }

        return endIndex;
    }
}