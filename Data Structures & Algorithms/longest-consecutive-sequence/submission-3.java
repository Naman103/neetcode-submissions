class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length == 0) return 0;
      Set<Integer> numbers = new TreeSet<>();
      for(int num : nums)
        numbers.add(num);

      int  prevNum = 0;
      int subSequenceLength = 0, maxSubSequenceLength = 1;
      int i = 0;
      for(int num : numbers) {
        System.out.print(num + "," + prevNum + " : ");
        if(i == 0) {
            subSequenceLength = 1;
        } else {
        if(num - prevNum == 1)
            subSequenceLength++;
        else subSequenceLength = 1;
        if(subSequenceLength > maxSubSequenceLength)
            maxSubSequenceLength = subSequenceLength;
        }
        prevNum = num;
        i++;
      }

      return maxSubSequenceLength;
    }
}
