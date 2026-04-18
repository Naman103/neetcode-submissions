class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> reverseSum = new ArrayList<>();

        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sumValue = digits[i] + carry;
            carry = sumValue / 10;
            reverseSum.add(sumValue % 10);
        }

        while(carry != 0) {
            reverseSum.add(carry % 10);
            carry /= 10;
        }
        
        int n = reverseSum.size();
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = reverseSum.get(n - i - 1);
        }

        return result;
    }
}
