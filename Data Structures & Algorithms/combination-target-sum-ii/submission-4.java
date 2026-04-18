class Solution {
    HashSet<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new HashSet<>();
        Arrays.sort(candidates);
        prepareSubSetSum(new ArrayList<>(), 0, candidates, target);
        return new ArrayList<>(result);
        
    }

    public void prepareSubSetSum(List<Integer> subSet, int curIndex, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        if (curIndex >= candidates.length || target < 0)
            return;

        subSet.add(candidates[curIndex]);
        prepareSubSetSum(subSet, curIndex + 1, candidates, target - candidates[curIndex]);
        subSet.remove(subSet.size() - 1);
        prepareSubSetSum(subSet, curIndex + 1, candidates, target);
    }
}
