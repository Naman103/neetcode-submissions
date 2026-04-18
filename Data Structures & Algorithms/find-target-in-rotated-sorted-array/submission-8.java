class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.print("Pivot : " + pivot);
        int n = nums.length;

        int result = binarySearch(0, pivot, nums, target);

        if (result == -1)
            result = binarySearch(pivot, n, nums, target);
        
        return result;
    }

    public int binarySearch(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] == target)
                return mid;
            
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return -1;
    }

    // Min value index is the pivot
    public int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
