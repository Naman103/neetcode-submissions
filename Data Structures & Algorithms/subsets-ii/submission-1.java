class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), false);
        return result;
    }

    public void backtrack(int[] nums, int currentIndex, List<Integer> current, boolean prevTaken) {
        if (currentIndex == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        backtrack(nums, currentIndex + 1, current, false);

        if (currentIndex > 0 && nums[currentIndex] == nums[currentIndex - 1] && !prevTaken) {
            return;
        }

        current.add(nums[currentIndex]);
        backtrack(nums, currentIndex + 1, current, true);
        current.remove(current.size() - 1);
    }

}
