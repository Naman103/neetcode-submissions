class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            return 1/myPow(x, -n);
        }

        double result = myPow(x, n/2);
        result *= result;

        if (n % 2 != 0) 
            result *= x;
        
        return result;
    }
}
