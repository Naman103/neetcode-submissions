class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        permutations(nums, 0, nums.length - 1);
        return new ArrayList<>(result);
    }

    public void permutations(int[] nums, int start, int end) {
        if(start >= nums.length || end < 0) {
            return;
        }

        result.add(fetchList(nums));
        swap(nums, start, end);
        permutations(nums, start, end - 1);
        permutations(nums, start + 1, end);
        swap(nums, start, end);
        permutations(nums, start + 1, end);
        permutations(nums, start, end - 1);
    }

    public List<Integer> fetchList(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        for(int num : nums)
            resList.add(num);
        return resList;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
