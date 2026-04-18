class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNumber = new HashSet<>();
        while (!visitedNumber.contains(n)) {
            visitedNumber.add(n);
            n = calculateSumSquare(n);
            if (n == 1)
                return true;
            
        }

        return false;
    }

    public int calculateSumSquare(int n) {
        int sum = 0;
        int rem = 0;
        while (n != 0) {
            rem = n % 10;
            sum += rem * rem;
            n = n/10;
        }

        return sum;
    }
}
