class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        prepareSubSets(new ArrayList<>(), nums, 0);
        return result;
    }

    public void prepareSubSets(List<Integer> subSets, int[] nums, int curIndex) {
        if (curIndex >= nums.length) {
            result.add(new ArrayList<>(subSets));
            return;
        }

        subSets.add(nums[curIndex]);
        prepareSubSets(subSets, nums, curIndex + 1);
        subSets.remove(subSets.size() - 1);
        prepareSubSets(subSets, nums, curIndex + 1);
    }
}
