class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (int)(left + right)/2;
            if(nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        if(right == -1) return nums[0];
        if(left == nums.length) return nums[nums.length - 1];
        return Math.min(nums[left], nums[right]);
    }
}
