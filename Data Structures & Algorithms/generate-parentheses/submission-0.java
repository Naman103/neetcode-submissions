class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        prepareParanthesis("", res, n, 0, 0);
        return res;
    }


    public void prepareParanthesis(String s, List<String> res, int n, int openBracketCount, int closedBracketCount) {
        if(openBracketCount == closedBracketCount && openBracketCount == n) {
            res.add(s);
            return;
        }
        
        if(openBracketCount < n)
            prepareParanthesis(s + "(", res, n, openBracketCount + 1, closedBracketCount);
        
        if(closedBracketCount < openBracketCount)
            prepareParanthesis(s + ")", res, n, openBracketCount, closedBracketCount + 1);

    }
}
