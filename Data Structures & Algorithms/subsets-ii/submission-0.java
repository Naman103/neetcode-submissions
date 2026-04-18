class Solution {
    HashSet<List<Integer>> subsets = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        prepareSubSets(new ArrayList<>(), nums, 0);
        return new ArrayList<>(subsets);
    }

    public void prepareSubSets(List<Integer> res, int[] nums, int start) {
        if(start >= nums.length) {
            subsets.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[start]);
        prepareSubSets(res, nums, start + 1);
        res.remove(res.size() - 1);
        prepareSubSets(res, nums, start + 1);
    }
} 
