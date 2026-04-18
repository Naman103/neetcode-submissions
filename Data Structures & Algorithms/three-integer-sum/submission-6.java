class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while(left < nums.length && right >= 0 && left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> zeroSumList = new ArrayList<>();
                    zeroSumList.add(nums[left]);
                    zeroSumList.add(nums[right]);
                    zeroSumList.add(nums[i]);

                    result.add(zeroSumList);

                    int firstNumber = nums[left], lastNumber = nums[right];
                    while(left < nums.length && nums[left] == firstNumber)
                        left++;
                    while(right >= 0 && nums[right] == lastNumber)
                        right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            int startValue = nums[i];
            while(i < nums.length && nums[i] == startValue)
                i++;
        }

        return result;   
    }
}
