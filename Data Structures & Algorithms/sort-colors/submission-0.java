class Solution {
    // If forget constraint
    // then just count elements and then fill accordingly
    // But it requires in-place which means i cannot use another and
    // then fill my value
    // int index = 0;
    // a loop from index to n whenever i get zero replace with the element at index
    // and add index 
    // starting value of index should be index where element is not 0
    // after that one more loop for 1
    // and another loop for 2
    // but the above solution is not good for scalable
    //
    public void sortColors(int[] nums) {
        int zeroIndex = 0, twoIndex = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex <= twoIndex) {
            if (nums[currentIndex] == 0) {
                swap(nums, zeroIndex, currentIndex);
                zeroIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, twoIndex);
                twoIndex--;
                currentIndex--;
            }

            currentIndex++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}