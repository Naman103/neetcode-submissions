class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while(index1 < index2 ) {
            int sum = numbers[index1] + numbers[index2]; 
            if(sum == target)
                return new int[] {index1 +1 , index2 + 1};
            else if(target < sum)
                index2--;
            else
                index1++;
        }

        return new int[] {-1, -1};
    }
}
