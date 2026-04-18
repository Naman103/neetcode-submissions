class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        prepareSubSet(new ArrayList<>(), nums, target, 0);
        return result;
    }

    public void prepareSubSet(List<Integer> subSet, int[] nums, int target, int curIndex) {
        // break conditions
        if (target == 0)    {
            result.add(new ArrayList<>(subSet));
            return;
        }

        if (curIndex >= nums.length || target < 0)
            return;
        
        subSet.add(nums[curIndex]);
        prepareSubSet(subSet, nums, target - nums[curIndex], curIndex);
        subSet.remove(subSet.size() - 1);
        prepareSubSet(subSet, nums, target, curIndex + 1);
    }
}
