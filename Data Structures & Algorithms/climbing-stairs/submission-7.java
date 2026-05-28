class Solution {
    Integer[] result;
    public int climbStairs(int n) {
        if (result == null)
            result = new Integer[n + 1];

        if (result[n] != null)
            return result[n];
        if (n <= 1) {  
            result[n] = 1;
        } else {
            result[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        return result[n];
    }
}
