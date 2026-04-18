class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParanthesis("", 0, 0, n);
        return result;
    }

    public void generateParanthesis(String s, int leftBracCount, int rightBracCount, int n) {
        if(leftBracCount == n && rightBracCount == n) {
            result.add(s);
            return;
        }
        
        if(leftBracCount < n)
            generateParanthesis(s + "(", leftBracCount + 1, rightBracCount, n);
        if(rightBracCount < leftBracCount)
            generateParanthesis(s + ")", leftBracCount, rightBracCount + 1, n);
    }
}
