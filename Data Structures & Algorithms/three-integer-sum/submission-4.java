class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); 
        int i = 0;
        boolean found = false;
        while(i < nums.length) {
            found = false;
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end];
                if(sum == target) {
                    List<Integer> subResult = Arrays.asList(nums[i], nums[start], nums[end]);
                    result.add(subResult);
                    int initStartValue = nums[start], initEndValue = nums[end];
                    
                    while(start < nums.length && nums[start] == initStartValue)
                        start++;
                    
                    while(end >= 0 && nums[end] == initEndValue)
                        end--;
                    
                    found = true;
                    
                } else if (target > sum) {
                    start++;
                } else {
                    end--;
                }
            }

            if(found) {
                int iValue = nums[i];
                while(i < nums.length && nums[i] == iValue)
                    i++;
            } else {
                i++;
            }
        }

        return result;
    }
}
