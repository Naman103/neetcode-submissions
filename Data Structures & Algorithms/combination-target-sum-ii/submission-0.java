class Solution {
    HashSet<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        prepareSum(new ArrayList<>(), candidates, 0, target);
        return new ArrayList<>(result);
    }

    public void prepareSum(List<Integer> res, int[] candidates, int start, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }

        if(target < 0 || start >= candidates.length)
            return;
        
        res.add(candidates[start]);
        prepareSum(res, candidates, start + 1, target - candidates[start]);
        res.remove(res.size() - 1);
        prepareSum(res, candidates, start + 1, target);
    }
}
