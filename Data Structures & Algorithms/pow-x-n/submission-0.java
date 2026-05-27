class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0.0d;
        if (n == 0) return 1.0d;
        double result = 1.0;
        int pow = n;
        if (pow < 0)
            pow = -pow;

        while(pow != 0) {
            result *= x;
            pow--;
        }
        
        if (n < 0)
            result = 1/result;
        
        return result;
    }
}
