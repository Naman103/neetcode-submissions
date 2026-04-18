class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedMap = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(visitedMap.containsKey(target - nums[i])) {
                result[0] = visitedMap.get(target - nums[i]);
                result[1] = i;

                break;
            }
            
            visitedMap.put(nums[i], i);
        }

        return result;
    }
}
