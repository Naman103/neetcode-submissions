class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNumber = new HashSet<>();
        while(n != 1) {
            if(visitedNumber.contains(n))
                return false;
            
            visitedNumber.add(n);
            n = sumOfSquareOfDigits(n);
        }

        return true;
    }

    public int sumOfSquareOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n /= 10;
        }

        return sum;
    }
}
