class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        sumList(res, target, nums, 0);
        return result;
    }

    public void sumList(List<Integer> res, int target, int[] nums, int start) {
        if(target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }

        if(target < 0 || start >= nums.length)
            return;
        
        res.add(nums[start]);
        if(target - nums[start] > 0)
            sumList(res, target - nums[start], nums, start);  
        else
            sumList(res, target - nums[start], nums, start + 1);
        res.remove(res.size() - 1);
        sumList(res, target, nums, start + 1);
    }
}
