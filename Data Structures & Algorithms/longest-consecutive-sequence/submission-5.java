class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numSet = new TreeSet<>();
        for(int num : nums)
            numSet.add(num);
        
        int length = 1, maxLength = 1 ;
        for(int num : numSet) {
            if(numSet.contains(num - 1)) {
                length++;
            } else {
                length = 1;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
