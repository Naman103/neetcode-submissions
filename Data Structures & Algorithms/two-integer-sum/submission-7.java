class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> conjugateMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int conjugateValue = target - nums[i];
            if (conjugateMap.containsKey(conjugateValue)) {
                return new int[] {conjugateMap.get(conjugateValue), i};
            }

            conjugateMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
