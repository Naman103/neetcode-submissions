class Solution {
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > nums.length/2)
        .findFirst().get().getKey();
        
    }
}