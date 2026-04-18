class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end && start < nums.length && end >=0) {
                int sum = nums[start] + nums[end];
                if(sum == target) {
                    //add
                    System.out.println("First: " + i + ",Start : " + start + ", End : " + end);
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[start]);
                    subResult.add(nums[end]);
                    result.add(subResult);
                    //and move start end to point where other values are added
                    int firstNumber = nums[start], lastNumber = nums[end];
                    while(start < nums.length && nums[start] == firstNumber)
                        start++;
                    while(end >= 0 && nums[end] == lastNumber)
                        end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }

            while(i < nums.length && nums[i] == -target)
                i++;
        }

        return result;
    }
}
