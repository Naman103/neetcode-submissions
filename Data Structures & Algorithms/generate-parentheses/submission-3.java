class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParanthesis("", 0, 0, n);
        return result;
    }

    public void generateParanthesis(String s, int left, int right, int n) {
        if(left == right && left == n) {
            result.add(s);
            return;
        }

        if (right > left || left > n || right > n)
            return;
        
        generateParanthesis(s + '(', left + 1, right, n);
        generateParanthesis(s + ')', left, right + 1, n);


    }
}
