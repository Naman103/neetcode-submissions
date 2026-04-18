class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> targetIndexMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int s2 = target - nums[i];
            if(targetIndexMap.containsKey(s2)) {
                return new int[] { targetIndexMap.get(s2), i};
            }

            targetIndexMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
