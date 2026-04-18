class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Set<Integer> sumSet = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++) {
                if(sumSet.contains(target - nums[j])) {
                    List<Integer> zeroSumList = Arrays.asList(nums[i], nums[j], target - nums[j]);
                    Collections.sort(zeroSumList);
                    result.add(zeroSumList);
                } else {
                    sumSet.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }
}
