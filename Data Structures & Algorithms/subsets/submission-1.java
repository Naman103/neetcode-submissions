class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSetList = new ArrayList<>();
        prepareSubSets(subSetList, nums, 0);
        return result;
        
    }

    public void prepareSubSets(List<Integer> res, int[] nums, int start) {
        if(start >= nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        
        res.add(nums[start]);
        prepareSubSets(res, nums, start + 1);
        res.remove(res.size() - 1);
        prepareSubSets(res, nums, start + 1);
    }

}
